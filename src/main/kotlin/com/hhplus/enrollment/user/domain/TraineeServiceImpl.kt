package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.data.TraineeQueryData
import com.hhplus.enrollment.user.domain.data.TraineeData
import com.hhplus.enrollment.user.infrastructure.TraineeRepository
import org.springframework.stereotype.Service

@Service
class TraineeServiceImpl(
    private val traineeRepository: TraineeRepository
): TraineeService {
    override fun getTrainee(param: TraineeQueryData): TraineeData {
        val result = traineeRepository.getTrainees(param.toQuery())
        return TraineeData.from(result)
    }
}