package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.exception.LectureCapacityExceededException
import com.hhplus.enrollment.lecture.exception.LectureInPastException
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import java.time.LocalDateTime

data class LectureData(
    var id: Long,
    var tutorId: Long,
    var capacity: Int,
    var date: LocalDateTime,
    var openYn: Char,

    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var useYn: Char,
) {
    companion object {
        fun from(dto: LectureEntity): LectureData = LectureData(
            id = dto.id,
            tutorId = dto.tutorId,
            capacity = dto.capacity,
            date = dto.date,
            openYn = dto.openYn,
            createdAt = dto.createdAt,
            updatedAt = dto.updatedAt,
            useYn = dto.useYn,
        )
    }

    fun toDto(): LectureDto {
        return LectureDto(
            id = id,
            tutorId = tutorId,
            capacity = capacity,
            date = date,
            openYn = openYn,
            createdAt = createdAt,
            updatedAt = updatedAt,
            useYn = useYn,
        )
    }
}