package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto

interface LectureRepository {
    fun getLecture(query: LectureQueryDto): LectureDto
    fun getAvailableLectures(): List<LectureDto>

    fun enroll(command: LectureDto): LectureDto

}