package com.hhplus.enrollment.lecutre.domain.fake

import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrolledLectureHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureHistoryEntity

class FakeLectureHistoryRepository: LectureHistoryRepository {
    private val historyies = mutableListOf<LectureHistoryEntity>()

    init {
        val TRAINEE_1_HISTORY = LectureHistoryEntity(2L, 1L, 1L, 'Y', 'N')
        val TRAINEE_1_HISTORY_CANCEL = LectureHistoryEntity(2L, 1L, 1L, 'Y', 'Y')
        val TRAINEE_2_HISTORY = LectureHistoryEntity(3L, 2L, 1L, 'Y', 'N')

        historyies.add(TRAINEE_1_HISTORY)
        historyies.add(TRAINEE_1_HISTORY_CANCEL)
        historyies.add(TRAINEE_2_HISTORY)
    }

    override fun insert(command: LectureHistoryCommandDto): LectureHistoryDto {
        historyies.add(command.toEntity())
        return LectureHistoryDto.from(command.toEntity())
    }

    override fun getEnrollmentHistories(query: LectureHistoryQueryDto): List<LectureHistoryDto> {
        val results = historyies
            .filter { query.traineeId == it.traineeId }
            .map { LectureHistoryDto.from(it) }
        return results
    }

    override fun getEnrolledHistory(query: EnrolledLectureHistoryQueryDto): LectureHistoryDto? {
        val results = historyies
            .filter { it.traineeId == query.traineeId && it.lectureId == query.lectureId }
            .sortedBy { it.createdAt }
            .map { LectureHistoryDto.from(it) }.firstOrNull()

        return results
    }

}