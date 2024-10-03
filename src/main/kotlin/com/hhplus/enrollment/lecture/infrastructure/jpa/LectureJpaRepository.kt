package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface LectureJpaRepository: JpaRepository<LectureEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun findById(lectureId: Long): Optional<LectureEntity>

    fun findByCapacityGreaterThan(capacity: Long? = 0): List<LectureEntity>
}