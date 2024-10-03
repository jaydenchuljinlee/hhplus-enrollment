package com.hhplus.enrollment.lecture.controller.response

import com.hhplus.enrollment.lecture.usecase.info.LectureInfo
import java.time.LocalDateTime

data class LectureResponse(
    var id: Long,
    var tutorId: Long,
    var capacity: Int,
    var date: LocalDateTime,
    var openYn: Char,
) {
    companion object {
        fun from(info: LectureInfo): LectureResponse {
            return LectureResponse(
                id = info.id,
                tutorId = info.tutorId,
                capacity = info.capacity,
                date = info.date,
                openYn = info.openYn,
            )
        }
    }
}