package com.hhplus.enrollment.lecture.infrastructure.dto

data class LectureQueryDto(
    var lectureId: Long
) {
    companion object {
        fun of(lectureId: Long): LectureQueryDto {
            return LectureQueryDto(lectureId)
        }
    }
}