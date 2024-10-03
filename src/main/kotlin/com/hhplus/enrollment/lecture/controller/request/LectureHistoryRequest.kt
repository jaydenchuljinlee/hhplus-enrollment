package com.hhplus.enrollment.lecture.controller.request

import com.hhplus.enrollment.lecture.usecase.info.LectureHistoryCommandInfo

class LectureHistoryRequest{
    data class Query(
        var traineeId: Long
    ) {
        init {
            require(traineeId >= 0) { "수강자 ID를 올바르게 입력해주세요." }
        }

        fun toInfo(): LectureHistoryCommandInfo {
            return LectureHistoryCommandInfo(traineeId)
        }
    }
}