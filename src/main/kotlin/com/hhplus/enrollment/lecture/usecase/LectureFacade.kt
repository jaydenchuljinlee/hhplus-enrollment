package com.hhplus.enrollment.lecture.usecase

import com.hhplus.enrollment.lecture.usecase.info.*

interface LectureFacade {
    fun enroll(command: LectureCommandInfo): LectureInfo
    fun getLectureHistories(command: LectureHistoryCommandInfo): List<LectureHistoryInfo>

    fun getGroupedAvailableLectures(): List<LectureDetailInfo>
}