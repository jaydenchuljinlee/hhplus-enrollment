package com.hhplus.enrollment.lecture.controller.response

import com.hhplus.enrollment.lecture.usecase.info.LectureDetailInfo
import java.time.LocalDateTime

data class LectureDetailResponse(
    var id: Long,
    var tutorId: Long,
    var tutorName: String,
    var description: String,
    var capacity: Int,
    var date: LocalDateTime,
    var openYn: Char,
) {
    companion object {
        fun from(info: LectureDetailInfo): LectureDetailResponse {
            return LectureDetailResponse(
                id = info.id,
                tutorId = info.tutorId,
                tutorName = info.tutorName,
                description = info.description,
                capacity = info.capacity,
                date = info.date,
                openYn = info.openYn,
            )
        }
    }
}