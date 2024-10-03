package com.hhplus.enrollment.lecutre.domain

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.LectureServiceImpl
import com.hhplus.enrollment.lecture.domain.data.LectureCommandData
import com.hhplus.enrollment.lecture.domain.data.LectureQueryData
import com.hhplus.enrollment.lecture.domain.validator.LectureValidator
import com.hhplus.enrollment.lecture.exception.LectureCapacityExceededException
import com.hhplus.enrollment.lecture.exception.LectureInPastException
import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecutre.domain.fake.FakeLectureHistoryRepository
import com.hhplus.enrollment.lecutre.domain.fake.FakeLectureRepository
import com.hhplus.enrollment.lecutre.domain.fake.FakeTraineeService
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LectureServiceTest {
    private lateinit var sut: LectureService

    private lateinit var lectureHistoryRepository: LectureHistoryRepository
    private lateinit var validator: LectureValidator

    @BeforeEach
    fun before() {
        lectureHistoryRepository = FakeLectureHistoryRepository()
        validator = LectureValidator(FakeTraineeService(), lectureHistoryRepository)

        sut = LectureServiceImpl(FakeLectureRepository(), lectureHistoryRepository, validator)
    }

    @DisplayName("유효성 검사에 걸리면 수강 신청이 실패한다.")
    @Test
    fun failIfInvalid() {
        // Given
        val TRAINEE_ID = 1L
        val LECTURE_ID = 1L
        val data = LectureCommandData(LECTURE_ID, TRAINEE_ID)
        val queryData = LectureQueryData(LECTURE_ID)
        val beforeLecture = sut.getLecture(queryData)

        assertThrows(RuntimeException::class.java) {
            sut.enroll(data)
        }

        val afterLecture = sut.getLecture(queryData)
        // Then
        assertEquals(beforeLecture.capacity, afterLecture.capacity)
    }

    @DisplayName("신청 인원이 초과되면 신청이 실패한다.")
    @Test
    fun failIfExceedCapacity() {
        // Given
        val LECTURE_ID = 1L

        val FIRST_TRAINEE_ID = 3L
        val firstData = LectureCommandData(LECTURE_ID, FIRST_TRAINEE_ID)
        sut.enroll(firstData)

        val SECOND_TRAINEE_ID = 4L
        val secondData = LectureCommandData(LECTURE_ID, SECOND_TRAINEE_ID)

        // When
        val exception = assertThrows(LectureCapacityExceededException::class.java) {
            sut.enroll(secondData)
        }

        val queryData = LectureQueryData(LECTURE_ID)
        val lecture = sut.getLecture(queryData)

        // Then
        assertEquals(exception.message, "강의 인원이 초과되었습니다.")
        assertEquals(lecture.capacity, 0)
    }

    @DisplayName("현재 날짜 이전의 강의는 신청에 실패한다.")
    @Test
    fun failIfPastDate() {
        // Given
        val LECTURE_ID = 4L
        val TRAINEE_ID = 3L
        val data = LectureCommandData(LECTURE_ID, TRAINEE_ID)

        // When
        val exception = assertThrows(LectureInPastException::class.java) {
            sut.enroll(data)
        }

        // Then
        assertEquals(exception.message, "현재 이후의 강의만 신청 가능합니다.")
    }
}