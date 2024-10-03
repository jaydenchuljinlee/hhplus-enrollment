package com.hhplus.enrollment.lecture.infrastructure.dto

data class EnrolledLectureHistoryQueryDto(
    var traineeId: Long,
    var lectureId: Long
) {
    companion object {
        fun of(traineeId: Long, lectureId: Long): EnrolledLectureHistoryQueryDto {
            return EnrolledLectureHistoryQueryDto(traineeId, lectureId)
        }
    }
}