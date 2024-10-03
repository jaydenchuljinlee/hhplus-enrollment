package com.hhplus.enrollment.lecutre.controller

import com.hhplus.enrollment.lecture.controller.LectureController
import com.hhplus.enrollment.lecture.controller.request.LectureRequest
import com.hhplus.enrollment.lecture.usecase.LectureFacade
import com.hhplus.enrollment.lecture.usecase.info.LectureInfo
import com.hhplus.enrollment.lecutre.controller.fake.FakeLectureFacade
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LectureControllerTest {
    private lateinit var sut: LectureController

    private lateinit var lectureFacade: LectureFacade

    @BeforeEach
    fun before() {
        lectureFacade = FakeLectureFacade()
        sut = LectureController(lectureFacade)
    }

    @DisplayName("success: 수강 신청 API")
    @Test
    fun testEnrollment() {
        // Given
        val request = LectureRequest.Command(1L, 1L)
        val lecture = LectureInfo(1L, 1L, 10, LocalDateTime.now().plusDays(1), 'Y')

        // When
        val response = sut.enroll(request)

        // Then
        assertEquals(response.id, 1L)
        assertEquals(response.tutorId, 1L)
        assertEquals(response.capacity, 10)
        assertEquals(response.openYn, 'Y')
    }

    @DisplayName("success: 신청 내역 조회 API")
    @Test
    fun testGetEnrollmentHistories() {
        // Given
        val TRAINEE_ID = 1L

        // When
        val results = sut.getEnrollmentHistories(TRAINEE_ID)

        // Then
        assertAll(
            { assertEquals(results.size, 1) },
            { assertEquals(results[0].id, 1L) },
            { assertEquals(results[0].lectureId, 1L) },
            { assertEquals(results[0].traineeId, 1L) },
            { assertEquals(results[0].acceptYn, true) },
            { assertEquals(results[0].cancelYn, false) },
        )
    }

    @DisplayName("success: 신청 가능한 날짜 조회")
    @Test
    fun testGetAvailableLectureList() {
        // Given
        val NOW_FORMAT = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        // When
        val results = sut.getLectureList()

        // Then
        assertTrue(results.response.containsKey(NOW_FORMAT))
        assertTrue(results.response[NOW_FORMAT] != null)
        assertTrue(results.response[NOW_FORMAT]?.get(0)?.id == 1L)
        assertTrue(results.response[NOW_FORMAT]?.get(0)?.tutorId == 1L)
        assertTrue(results.response[NOW_FORMAT]?.get(0)?.tutorName == "토비")
        assertTrue(results.response[NOW_FORMAT]?.get(0)?.description == "토비의 스프링")
        assertTrue(results.response[NOW_FORMAT]?.get(0)?.capacity == 10)
        assertTrue(results.response[NOW_FORMAT]?.get(0)?.openYn == 'Y')
    }
}