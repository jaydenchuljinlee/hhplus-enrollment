package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.data.TraineeQueryData
import com.hhplus.enrollment.user.domain.data.TraineeData

interface TraineeService {
    fun getTrainee(param: TraineeQueryData): TraineeData
}