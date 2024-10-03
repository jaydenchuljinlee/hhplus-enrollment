package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.data.*
import com.hhplus.enrollment.lecture.domain.validator.LectureValidator
import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.LectureRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryCommandDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class LectureServiceImpl(
    private val lectureRepository: LectureRepository,
    private val lectureHistoryRepository: LectureHistoryRepository,
    private val validator: LectureValidator
): LectureService {
    override fun getLecture(query: LectureQueryData): LectureData {
        val result = lectureRepository.getLecture(query.toDto())
        return LectureData.from(result)
    }

    override fun getAvailableLectures(): List<LectureData> {
        val result = lectureRepository.getAvailableLectures()
        return result.map { LectureData.from(it) }
    }

    @Transactional
    override fun enroll(query: LectureCommandData): LectureData {
        validator.validate(query) // 수강자 정보, 신청 이력에 대한 유효성 검사

        val lecture = getLecture(LectureQueryData.of(query.lectureId)) // 강의 정보 조회. 내부에서 유효성 검사
        lecture.enroll() // 수강 신청. 내부에서 유효성 검사

        lectureRepository.enroll(lecture.toDto()) // 참감 된 수강 정보 저장

        // 강의 이력 저장
        val historyCommand = LectureHistoryCommandDto.of(query.lectureId, query.traineeId)
        lectureHistoryRepository.insert(historyCommand)
        return lecture
    }

    override fun getLectureHistories(query: LectureHistoryQueryData): List<LectureHistoryData> {
        val result = lectureHistoryRepository.getEnrollmentHistories(query.toDto())
        return result.map { LectureHistoryData.from(it) }
    }
}