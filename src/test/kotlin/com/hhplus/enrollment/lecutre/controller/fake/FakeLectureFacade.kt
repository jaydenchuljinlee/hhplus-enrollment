package com.hhplus.enrollment.lecutre.controller.fake

import com.hhplus.enrollment.lecture.exception.LectureNotFoundException
import com.hhplus.enrollment.lecture.usecase.LectureFacade
import com.hhplus.enrollment.lecture.usecase.info.*
import com.hhplus.enrollment.user.domain.data.TutorData
import java.time.LocalDateTime

class FakeLectureFacade: LectureFacade {
    val lectures = mutableMapOf<Long, LectureInfo>()
    val tutors = mutableMapOf<Long, TutorData>()
    val lectureHistories = mutableListOf<LectureHistoryInfo>()

    init {
        val tutor = TutorData(1L, "토비의 스프링", "토비", "01012345678", "abs@gmail.com")
        tutors[tutor.id] = tutor

        val lecture = LectureInfo(1L, tutor.id, 10, LocalDateTime.now(), 'Y')
        lectures[lecture.id] = lecture

        val history = LectureHistoryInfo(1L, lecture.id, 1L, true, false)
        lectureHistories.add(history)
    }

    override fun enroll(command: LectureCommandInfo): LectureInfo {
        val history = LectureHistoryInfo(1L, command.lectureId, command.traineeId, true, false)
        lectureHistories.add(history)

        val lecture = lectures[command.lectureId] ?: throw LectureNotFoundException()
        return lecture
    }

    override fun getLectureHistories(command: LectureHistoryCommandInfo): List<LectureHistoryInfo> {
        val results = lectureHistories.filter {it.traineeId == command.traineeId}
        return results
    }

    override fun getGroupedAvailableLectures(): List<LectureDetailInfo> {
        val results = mutableListOf<LectureDetailInfo>()

        lectures.values.map {
            val tutor = tutors[it.tutorId]?: throw LectureNotFoundException()

            val detail = LectureDetailInfo(it.id, tutor.id, tutor.name, tutor.description, it.capacity, it.date, it.openYn)
            results.add(detail)
        }

        return results
    }

}