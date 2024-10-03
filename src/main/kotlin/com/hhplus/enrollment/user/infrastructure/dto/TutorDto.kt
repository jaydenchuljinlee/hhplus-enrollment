package com.hhplus.enrollment.user.infrastructure.dto

import com.hhplus.enrollment.user.infrastructure.jpa.entity.TutorTable

data class TutorDto(
    var id: Long,
    var description: String,
    var name: String,
    var phoneNumber: String,
    var email: String
) {
    companion object {
        fun from(tutorTable: TutorTable): TutorDto {
            return TutorDto(
                id = tutorTable.id,
                description = tutorTable.description,
                name = tutorTable.name,
                phoneNumber = tutorTable.phoneNumber,
                email = tutorTable.email
            )
        }
    }
}