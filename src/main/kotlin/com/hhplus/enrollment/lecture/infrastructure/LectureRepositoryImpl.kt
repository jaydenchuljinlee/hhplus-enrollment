package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.exception.LectureNotFoundException
import com.hhplus.enrollment.lecture.infrastructure.jpa.LectureJpaRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import org.springframework.stereotype.Component

@Component
class LectureRepositoryImpl(
    private val lectureJpaRepository: LectureJpaRepository
): LectureRepository {
    override fun getLecture(query: LectureQueryDto): LectureEntity {
        val result = lectureJpaRepository.findById(query.lectureId).orElseThrow { LectureNotFoundException() }
        return result
    }

    override fun getAvailableLectures(): List<LectureEntity> {
        val results = lectureJpaRepository.findByCapacityGreaterThan()
        return results
    }

    override fun enroll(command: LectureEntity): LectureEntity {
        lectureJpaRepository.save(command)
        return command
    }
}