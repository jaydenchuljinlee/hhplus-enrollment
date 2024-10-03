package com.hhplus.enrollment.lecture.usecase.info

import com.hhplus.enrollment.lecture.domain.data.LectureData
import java.time.LocalDateTime

data class LectureInfo(
    var id: Long,
    var tutorId: Long,
    var capacity: Int,
    var date: LocalDateTime,
    var openYn: Char,
) {


    companion object {
        fun from(lecture: LectureData): LectureInfo = LectureInfo(
            id = lecture.id,
            tutorId = lecture.tutorId,
            capacity = lecture.capacity,
            date = lecture.date,
            openYn = lecture.openYn,
        )
    }
}