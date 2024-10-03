package com.hhplus.enrollment.lecture.usecase.info

import com.hhplus.enrollment.lecture.domain.data.LectureHistoryData

data class LectureHistoryInfo(
    var id: Long,
    var lectureId: Long,
    var traineeId: Long,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    companion object {
        fun from(data: LectureHistoryData): LectureHistoryInfo {
            return LectureHistoryInfo(
                id = data.id,
                lectureId = data.lectureId,
                traineeId = data.traineeId,
                acceptYn = data.acceptYn,
                cancelYn = data.cancelYn
            )
        }
    }
}