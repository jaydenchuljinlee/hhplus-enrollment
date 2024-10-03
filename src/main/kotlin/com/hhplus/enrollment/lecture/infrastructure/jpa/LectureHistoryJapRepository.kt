package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LectureHistoryJapRepository: JpaRepository<LectureHistoryEntity, Long> {
    fun findAllByTraineeId(traineeId: Long): List<LectureHistoryEntity>
    fun findTopByTraineeIdAndLectureIdOrderByCreatedAtDesc(traineeId: Long, lectureId: Long): Optional<LectureHistoryEntity>
}