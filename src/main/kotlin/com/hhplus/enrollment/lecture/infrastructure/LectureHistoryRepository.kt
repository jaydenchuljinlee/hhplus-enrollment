package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrolledLectureHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryQueryDto

interface LectureHistoryRepository {
    fun insert(command: LectureHistoryCommandDto): LectureHistoryDto
    fun getEnrollmentHistories(query: LectureHistoryQueryDto): List<LectureHistoryDto>
    fun getEnrolledHistory(query: EnrolledLectureHistoryQueryDto): LectureHistoryDto?
}