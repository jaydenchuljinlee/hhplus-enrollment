package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.exception.LectureCapacityExceededException
import com.hhplus.enrollment.lecture.exception.LectureInPastException
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto
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
        fun from(dto: LectureDto): LectureData = LectureData(
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

    fun enroll() {
        validateDate() // 날짜 유효성 검사
        decrease() // 수강 인원 차감
    }

    fun validateDate() {
        val now = LocalDateTime.now()
        require(now.isBefore(date)) { throw LectureInPastException() }
    }

    fun decrease() {
        require(capacity.minus(1) >= 0) { throw LectureCapacityExceededException() }
        capacity = capacity.minus(1)
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