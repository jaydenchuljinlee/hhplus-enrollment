package com.hhplus.enrollment

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.data.LectureCommandData
import com.hhplus.enrollment.lecture.domain.data.LectureHistoryQueryData
import com.hhplus.enrollment.lecture.domain.data.LectureQueryData
import com.hhplus.enrollment.lecture.exception.DuplicateEnrollmentException
import com.hhplus.enrollment.lecture.exception.LectureCapacityExceededException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

@SpringBootTest
class EnrollmentIntegrationTest {
    @Autowired
    private lateinit var lectureService: LectureService

    @DisplayName("한 번 수강 신청한 이력이 있는 수강자는 중복 신청을 못 한다.")
    @Test
    fun testDuplicateEnrollment() {
        var errorCnt = 0
        val totalRequests = 5

        val TRAINEE_ID = 41L
        val LECTURE_ID = 3L

        // 동시 요청을 대기할 Latch 설정
        val readyLatch = CountDownLatch(1)
        val completeLatch = CountDownLatch(5)

        // 스레드 풀 생성
        val executorService = Executors.newFixedThreadPool(totalRequests)

        // 5개의 요청을 비동기로 생성하여 실행
        for (i in 1..totalRequests) {
            executorService.submit {
                try {
                    // 모든 스레드가 준비될 때까지 대기
                    readyLatch.await()

                    // 요청마다 같은 수강생 ID를 사용하여 LectureCommandData 생성
                    val command = LectureCommandData(LECTURE_ID, TRAINEE_ID)

                    // 수강 신청
                    lectureService.enroll(command)
                } catch (e: DuplicateEnrollmentException) {
                    errorCnt++
                } finally {
                    // 요청 완료 시 Latch 카운트 감소
                    completeLatch.countDown()
                }
            }
        }

        // 모든 스레드가 시작되기를 준비한 후 동시에 시작
        readyLatch.countDown() // 모든 스레드가 동시에 시작하도록 Latch 해제

        // 모든 요청이 완료될 때까지 대기
        completeLatch.await()

        // 스레드 풀 종료
        executorService.shutdown()

        val query = LectureHistoryQueryData(TRAINEE_ID)
        val lectureHistory = lectureService.getLectureHistories(query)

        assertEquals(lectureHistory.size, 1) // 정확하게 한 번의 요청 이력이 남았는지 검사
        assertEquals(errorCnt, 4) // 나머지 요청은 실패한다.
    }

    @DisplayName("동시에 40명이 수강신청해도, 먼저 Lock을 획득한 30명의 사용자만 등록된다.")
    @Test
    fun test() {
        var errorCnt = 0

        val LECTURE_ID = 0L
        val beforeEntity = lectureService.getLecture(LectureQueryData(LECTURE_ID))

        val totalRequests = beforeEntity.capacity + 10 // 강의 수용량보다 10개가 많도록 설정

        // 동시 요청을 대기할 Latch 설정
        val readyLatch = CountDownLatch(1)
        val completeLatch = CountDownLatch(totalRequests)

        // 수강신청한 사용자 ID 리스트 (동기화 리스트로 생성)
        val successfulStudents = Collections.synchronizedList(mutableListOf<Pair<Int, Long>>())
        val failedStudents = Collections.synchronizedList(mutableListOf<Pair<Int, Long>>())

        // 스레드 풀 생성
        val executorService = Executors.newFixedThreadPool(totalRequests)

        // 40개의 요청을 비동기로 생성하여 실행
        for (i in 1..totalRequests) {
            executorService.submit {
                try {
                    // 모든 스레드가 준비될 때까지 대기
                    readyLatch.await()

                    // 요청마다 다른 수강생 ID를 사용하여 LectureCommandData 생성
                    val command = LectureCommandData(LECTURE_ID, i.toLong())

                    // 수강 신청
                    lectureService.enroll(command)

                    val pair = Pair(i, System.currentTimeMillis())
                    successfulStudents.add(pair)
                    // println("SUCCESS: ${pair.first} -> ${pair.second}")
                } catch (e: LectureCapacityExceededException) {
                    val pair = Pair(i, System.currentTimeMillis())
                    failedStudents.add(pair)
                    // println("FAILED: ${pair.first} -> ${pair.second}")
                    errorCnt++
                } finally {
                    // 요청 완료 시 Latch 카운트 감소
                    completeLatch.countDown()
                }
            }
        }

        // 모든 스레드가 시작되기를 준비한 후 동시에 시작
        readyLatch.countDown() // 모든 스레드가 동시에 시작하도록 Latch 해제

        // 모든 요청이 완료될 때까지 대기
        completeLatch.await()

        // 스레드 풀 종료
        executorService.shutdown()

        val afterEntity = lectureService.getLecture(LectureQueryData(LECTURE_ID))

        assertTrue(afterEntity.capacity == 0) // 원래 수용 인원보다 많은 인원이 요청했기 때문에, 수용량은 0이 되어야 한다.
        assertTrue(errorCnt == totalRequests - beforeEntity.capacity) // 실패한 갯수 = 10 (총 스레드 갯수를 수용량 + 10으로 정했기 때문)
        assertTrue(successfulStudents.last().second < failedStudents.first().second) // 현재 테스트가 선착순을 보장하는지 확인.
    }
}