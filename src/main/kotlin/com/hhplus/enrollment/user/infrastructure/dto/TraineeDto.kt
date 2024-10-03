package com.hhplus.enrollment.user.infrastructure.dto

import com.hhplus.enrollment.user.infrastructure.jpa.entity.TraineeTable

data class TraineeDto(
    var traineeId: Long,
    var name: String,
    var phoneNumber: String,
    var email: String
) {
    companion object {
        fun from(table: TraineeTable): TraineeDto {
            return TraineeDto(
                traineeId = table.id,
                name = table.name,
                phoneNumber = table.phoneNumber,
                email = table.email
            )
        }
    }
}