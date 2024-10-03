package com.hhplus.enrollment.lecture.usecase

import com.hhplus.enrollment.lecture.usecase.info.*
import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.user.domain.TutorService
import com.hhplus.enrollment.user.domain.data.TutorQueryData
import org.springframework.stereotype.Service

@Service
class LectureFacadeImpl(
    private val lectureService: LectureService,
    private val tutorService: TutorService
): LectureFacade {
    override fun enroll(command: LectureCommandInfo): LectureInfo {
        val result = lectureService.enroll(command.toData())
        return LectureInfo.from(result)
    }

    override fun getLectureHistories(command: LectureHistoryCommandInfo): List<LectureHistoryInfo> {
        val results = lectureService.getLectureHistories(command.toData())
        return results.map { LectureHistoryInfo.from(it) }
    }

    // 퍼사드 계층에서 날짜 별 신청 가능한 강의와 강의에 대한 강의자 정보를 조합하게 됩니다.
    override fun getGroupedAvailableLectures(): List<LectureDetailInfo> {
        val lectures = lectureService.getAvailableLectures()

        val tutorIds = lectures.map { it.tutorId }.distinct()
        val tutorQueryData = tutorIds.map { TutorQueryData(it) }
        val tutors = tutorService.getTutors(tutorQueryData)

        val results = lectures.map { lecture ->
            val tutor = tutors.first { it.id == lecture.tutorId }

            LectureDetailInfo.from(lecture, tutor)
        }

        return results
    }
}