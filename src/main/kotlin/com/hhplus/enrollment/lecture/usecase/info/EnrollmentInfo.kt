package com.hhplus.enrollment.lecture.usecase.info

import com.hhplus.enrollment.lecture.domain.data.LectureData
import java.time.LocalDateTime

data class EnrollmentInfo(
    var id: Long,
    var tutorId: Long,
    var capacity: Int,
    var date: LocalDateTime,
    var openYn: Char,
) {
    companion object {
        fun from(data: LectureData): LectureInfo = LectureInfo(
            id = data.id,
            tutorId = data.tutorId,
            capacity = data.capacity,
            date = data.date,
            openYn = data.openYn,
        )
    }
}