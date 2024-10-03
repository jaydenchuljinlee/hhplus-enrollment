package com.hhplus.enrollment.lecture.usecase.info

import com.hhplus.enrollment.lecture.domain.data.LectureHistoryQueryData

data class LectureHistoryCommandInfo(
    var traineeId: Long,
) {
    fun toData() = LectureHistoryQueryData(traineeId)
}