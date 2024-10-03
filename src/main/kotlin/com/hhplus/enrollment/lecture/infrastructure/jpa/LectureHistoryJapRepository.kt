package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureHistoryEntity
import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LectureHistoryJapRepository: JpaRepository<LectureHistoryEntity, Long> {
    fun findAllByTraineeId(traineeId: Long): List<LectureHistoryEntity>
    fun findTopByTraineeIdAndLectureIdAndCancelYn(traineeId: Long, lectureId: Long, cancelYn: Char = 'N'): Optional<LectureHistoryEntity>
}