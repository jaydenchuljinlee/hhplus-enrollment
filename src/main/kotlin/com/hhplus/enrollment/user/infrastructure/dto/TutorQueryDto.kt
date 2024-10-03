package com.hhplus.enrollment.user.infrastructure.dto

data class TutorQueryDto(
    var tutorId: Long
) {
    companion object {
        fun of(tutorId: Long): TutorQueryDto {
            return TutorQueryDto(tutorId)
        }
    }
}