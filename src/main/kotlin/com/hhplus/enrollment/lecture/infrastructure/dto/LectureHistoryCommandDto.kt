package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureHistoryEntity

data class LectureHistoryCommandDto(
    var lectureId: Long,
    var traineeId: Long,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    companion object {
        fun of(lectureId: Long, traineeId: Long): LectureHistoryCommandDto {
            return LectureHistoryCommandDto(lectureId, traineeId, acceptYn = false, cancelYn = false)
        }
    }

    fun toEntity(): LectureHistoryEntity {
        return LectureHistoryEntity(
            lectureId = lectureId,
            traineeId = traineeId,
            acceptYn = if (acceptYn) 'Y' else 'N',
            cancelYn = if (cancelYn) 'Y' else 'N'
        )
    }
}