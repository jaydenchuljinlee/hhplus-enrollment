package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryQueryDto

data class LectureHistoryQueryData(
    var traineeId: Long
) {
    fun toDto(): LectureHistoryQueryDto = LectureHistoryQueryDto(traineeId)
}