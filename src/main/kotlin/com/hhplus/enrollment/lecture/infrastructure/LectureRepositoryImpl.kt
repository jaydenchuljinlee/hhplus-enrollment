package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.exception.LectureNotFoundException
import com.hhplus.enrollment.lecture.infrastructure.jpa.LectureJpaRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto
import org.springframework.stereotype.Component

@Component
class LectureRepositoryImpl(
    private val lectureJpaRepository: LectureJpaRepository
): LectureRepository {
    override fun getLecture(query: LectureQueryDto): LectureDto {
        val result = lectureJpaRepository.findById(query.lectureId).orElseThrow { LectureNotFoundException() }
        return LectureDto.from(result)
    }

    override fun getAvailableLectures(): List<LectureDto> {
        val results = lectureJpaRepository.findByCapacityGreaterThan()
        return results.map { LectureDto.from(it) }
    }

    override fun enroll(command: LectureDto): LectureDto {
        lectureJpaRepository.save(command.toEntity())
        return command
    }
}