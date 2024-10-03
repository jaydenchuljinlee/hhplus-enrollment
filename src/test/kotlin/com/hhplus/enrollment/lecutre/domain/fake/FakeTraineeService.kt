package com.hhplus.enrollment.lecutre.domain.fake

import com.hhplus.enrollment.user.domain.TraineeService
import com.hhplus.enrollment.user.domain.data.TraineeQueryData
import com.hhplus.enrollment.user.domain.data.TraineeData
import com.hhplus.enrollment.user.exception.TraineeNotFoundException

class FakeTraineeService: TraineeService {
    private var trainees = mutableMapOf<Long, TraineeData>()

    init {
        val TRAINEE_1 = TraineeData(1,"이철진", "01089669169", "ironjin92@gmail.com")
        val TRAINEE_2 = TraineeData(2,"홍길동", "01089669169", "ironjin92@gmail.com")
        val TRAINEE_3 = TraineeData(3,"김유신", "01089669169", "ironjin92@gmail.com")
        val TRAINEE_4 = TraineeData(4,"이순신", "01089669169", "ironjin92@gmail.com")

        trainees[TRAINEE_1.traineeId] = TRAINEE_1
        trainees[TRAINEE_2.traineeId] = TRAINEE_2
        trainees[TRAINEE_3.traineeId] = TRAINEE_3
        trainees[TRAINEE_4.traineeId] = TRAINEE_4
    }

    override fun getTrainee(param: TraineeQueryData): TraineeData {
        return trainees[param.traineeId] ?: throw TraineeNotFoundException()
    }
}