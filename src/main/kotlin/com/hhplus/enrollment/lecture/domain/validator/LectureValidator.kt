package com.hhplus.enrollment.lecture.domain.validator

import com.hhplus.enrollment.lecture.domain.data.LectureCommandData
import com.hhplus.enrollment.lecture.exception.DuplicateEnrollmentException
import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrolledLectureHistoryQueryDto
import com.hhplus.enrollment.user.domain.TraineeService
import com.hhplus.enrollment.user.domain.data.TraineeQueryData
import org.springframework.stereotype.Component

@Component
class LectureValidator(
    private val traineeService: TraineeService,
    private val lectureHistoryRepository: LectureHistoryRepository,
) {

    fun validate(param: LectureCommandData) {
        val trainee = traineeService.getTrainee(TraineeQueryData.of(param.traineeId)) // 수강자 정보 조회

        val historyQuery = EnrolledLectureHistoryQueryDto.of(trainee.traineeId, param.lectureId) // 신청 이력 조회
        val appliedHistory = lectureHistoryRepository.getEnrolledHistory(historyQuery)

        // 신청했다가 다시 해제할 수도 있으니, 최신 신청 이력에서 검사한다.
        require(appliedHistory == null || appliedHistory.cancelYn) {
            throw DuplicateEnrollmentException()
        }
    }

}