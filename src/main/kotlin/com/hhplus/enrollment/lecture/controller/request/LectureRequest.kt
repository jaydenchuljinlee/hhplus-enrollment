package com.hhplus.enrollment.lecture.controller.request

import com.hhplus.enrollment.lecture.usecase.info.LectureCommandInfo

class LectureRequest{
    data class Command(
        var lectureId: Long,
        var traineeId: Long,
    ) {
        init {
            require(lectureId >= 0) { "강의 ID를 올바르게 입력해주세요." }
            require(traineeId >= 0) { "수강자 ID를 올바르게 입력해주세요." }
        }

        fun toInfo(): LectureCommandInfo {
            return LectureCommandInfo.of(lectureId, traineeId)
        }
    }
}