package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrolledLectureHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.LectureHistoryJapRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryQueryDto
import org.springframework.stereotype.Component

@Component
class LectureHistoryRepositoryImpl(
    private val jpaRepository: LectureHistoryJapRepository
): LectureHistoryRepository {
    override fun insert(command: LectureHistoryCommandDto): LectureHistoryDto {
        val results = jpaRepository.save(command.toEntity())
        return LectureHistoryDto.from(results)
    }

    override fun getEnrollmentHistories(query: LectureHistoryQueryDto): List<LectureHistoryDto> {
        val results = jpaRepository.findAllByTraineeId(query.traineeId)
        return results.map { LectureHistoryDto.from(it) }
    }

    override fun getEnrolledHistory(query: EnrolledLectureHistoryQueryDto): LectureHistoryDto? {
        val result = jpaRepository.findTopByTraineeIdAndLectureIdOrderByCreatedAtDesc(query.traineeId, query.lectureId)
        return if (result.isPresent) {
            LectureHistoryDto.from(result.get())
        } else null
    }
}