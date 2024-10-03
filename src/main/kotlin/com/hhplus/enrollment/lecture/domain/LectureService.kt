package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.data.*

interface LectureService {
    fun getLecture(query: LectureQueryData): LectureData  // Optional<LectureResult> 로 변경? Optional<Lecture> 로 변경?
    fun getAvailableLectures(): List<LectureData>

    fun enroll(query: LectureCommandData): LectureData
    fun getLectureHistories(query: LectureHistoryQueryData): List<LectureHistoryData>
}