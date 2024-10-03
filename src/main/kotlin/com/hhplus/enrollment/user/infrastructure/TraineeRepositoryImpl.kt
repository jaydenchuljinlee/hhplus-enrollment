package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.exception.TraineeNotFoundException
import com.hhplus.enrollment.user.infrastructure.jpa.TraineeJpaRepository
import com.hhplus.enrollment.user.infrastructure.dto.TraineeDto
import com.hhplus.enrollment.user.infrastructure.dto.TraineeQueryDto
import org.springframework.stereotype.Component

@Component
class TraineeRepositoryImpl(
    private val traineeJpaRepository: TraineeJpaRepository
): TraineeRepository {
    override fun getTrainees(query: TraineeQueryDto): TraineeDto {
        val result = traineeJpaRepository.findById(query.traineeId).orElseThrow { TraineeNotFoundException() }
        return TraineeDto.from(result)
    }
}