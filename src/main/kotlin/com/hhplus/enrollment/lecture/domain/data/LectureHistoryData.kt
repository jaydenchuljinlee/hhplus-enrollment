package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryDto

data class LectureHistoryData(
    var id: Long,
    var lectureId: Long,
    var traineeId: Long,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    companion object {
        fun from(dto: LectureHistoryDto) = LectureHistoryData(
            id = dto.id,
            lectureId = dto.lectureId,
            traineeId = dto.traineeId,
            acceptYn = dto.acceptYn,
            cancelYn = dto.cancelYn
        )
    }
}