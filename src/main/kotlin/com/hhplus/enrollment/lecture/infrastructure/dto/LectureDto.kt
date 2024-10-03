package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import java.time.LocalDateTime

data class LectureDto(
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
        fun from(entity: LectureEntity): LectureDto {
            return LectureDto(
                id = entity.id,
                tutorId = entity.tutorId,
                capacity = entity.capacity,
                date = entity.date,
                openYn = entity.openYn,
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt,
                useYn = entity.useYn,
            )
        }
    }

    fun toEntity(): LectureEntity {
        return LectureEntity(
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