package com.hhplus.enrollment.lecture.usecase.info

import com.hhplus.enrollment.lecture.domain.data.LectureCommandData

data class LectureCommandInfo(
    var lectureId: Long,
    var traineeId: Long,
) {
    companion object {
        fun of(lectureId: Long, traineeId: Long): LectureCommandInfo {
            return LectureCommandInfo(lectureId, traineeId)
        }
    }

    fun toData(): LectureCommandData {
        return LectureCommandData(lectureId, traineeId)
    }
}