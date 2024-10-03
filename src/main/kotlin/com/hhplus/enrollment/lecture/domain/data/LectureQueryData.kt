package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto

data class LectureQueryData(
    var lectureId: Long
) {
    companion object {
        fun of(lectureId: Long): LectureQueryData {
            return LectureQueryData(lectureId)
        }
    }

    fun toDto(): LectureQueryDto {
        return LectureQueryDto(lectureId)
    }
}