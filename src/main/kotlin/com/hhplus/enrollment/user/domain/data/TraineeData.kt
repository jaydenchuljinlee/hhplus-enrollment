package com.hhplus.enrollment.user.domain.data

import com.hhplus.enrollment.user.infrastructure.dto.TraineeDto

data class TraineeData(
    var traineeId: Long,
    var name: String,
    var phoneNumber: String,
    var email: String
) {
    companion object {
        fun from(projection: TraineeDto) = TraineeData(
            traineeId = projection.traineeId,
            name = projection.name,
            phoneNumber = projection.phoneNumber,
            email = projection.email
        )
    }
}