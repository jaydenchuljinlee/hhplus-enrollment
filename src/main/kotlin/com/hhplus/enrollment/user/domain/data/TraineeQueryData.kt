package com.hhplus.enrollment.user.domain.data

import com.hhplus.enrollment.user.infrastructure.dto.TraineeQueryDto

data class TraineeQueryData(
    var traineeId: Long
) {
    companion object {
        fun of(traineeId: Long): TraineeQueryData {
            return TraineeQueryData(traineeId)
        }
    }

    fun toQuery(): TraineeQueryDto {
        return TraineeQueryDto(traineeId)
    }
}