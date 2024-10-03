package com.hhplus.enrollment.lecture.controller.response

import com.hhplus.enrollment.lecture.usecase.info.LectureHistoryInfo

data class LectureHistoryResponse(
    var id: Long,
    var lectureId: Long,
    var traineeId: Long,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    companion object {
        fun from(info: LectureHistoryInfo) = LectureHistoryResponse(
            id = info.id,
            lectureId = info.lectureId,
            traineeId = info.traineeId,
            acceptYn = info.acceptYn,
            cancelYn = info.cancelYn
        )
    }
}