package com.hhplus.enrollment.user.infrastructure.jpa

import com.hhplus.enrollment.user.infrastructure.jpa.entity.TraineeTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

@Component
interface TraineeJpaRepository: JpaRepository<TraineeTable, Long> {
}