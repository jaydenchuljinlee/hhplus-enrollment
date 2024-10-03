package com.hhplus.enrollment.user.domain.data

import com.hhplus.enrollment.user.infrastructure.dto.TutorDto

data class TutorData(
    var id: Long,
    var description: String,
    var name: String,
    var phoneNumber: String,
    var email: String
) {
    companion object {
        fun from(projection: TutorDto): TutorData {
            return TutorData(
                id = projection.id,
                description = projection.description,
                name = projection.name,
                phoneNumber = projection.phoneNumber,
                email = projection.email,
            )
        }
    }
}