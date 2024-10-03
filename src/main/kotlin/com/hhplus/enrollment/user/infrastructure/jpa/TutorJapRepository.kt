package com.hhplus.enrollment.user.infrastructure.jpa

import com.hhplus.enrollment.user.infrastructure.jpa.entity.TutorTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TutorJapRepository: JpaRepository<TutorTable, Long> {
}