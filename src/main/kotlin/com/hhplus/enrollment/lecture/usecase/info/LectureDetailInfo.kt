package com.hhplus.enrollment.lecture.usecase.info

import com.hhplus.enrollment.lecture.domain.data.LectureData
import com.hhplus.enrollment.user.domain.data.TutorData
import java.time.LocalDateTime

data class LectureDetailInfo(
    var id: Long,
    var tutorId: Long,
    var tutorName: String,
    var description: String,
    var capacity: Int,
    var date: LocalDateTime,
    var openYn: Char,
) {
    companion object {
        fun from(lecture: LectureData, tutor: TutorData): LectureDetailInfo = LectureDetailInfo(
            id = lecture.id,
            tutorId = lecture.tutorId,
            tutorName = tutor.name,
            description = tutor.name,
            capacity = lecture.capacity,
            date = lecture.date,
            openYn = lecture.openYn,
        )
    }
}