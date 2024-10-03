package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureHistoryEntity

data class LectureHistoryDto(
    var id: Long,
    var lectureId: Long,
    var traineeId: Long,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    companion object {
        fun from(lectureHistoryEntity: LectureHistoryEntity): LectureHistoryDto {
            return LectureHistoryDto(
                id = lectureHistoryEntity.id,
                lectureId = lectureHistoryEntity.lectureId,
                traineeId = lectureHistoryEntity.traineeId,
                acceptYn = lectureHistoryEntity.acceptYn == 'Y',
                cancelYn = lectureHistoryEntity.cancelYn == 'Y'
            )
        }
    }
}