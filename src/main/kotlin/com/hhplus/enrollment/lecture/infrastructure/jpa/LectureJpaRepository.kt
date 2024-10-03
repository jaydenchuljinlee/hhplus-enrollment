package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LectureJpaRepository: JpaRepository<LectureEntity, Long> {
    fun findByCapacityGreaterThan(capacity: Long? = 0): List<LectureEntity>
}