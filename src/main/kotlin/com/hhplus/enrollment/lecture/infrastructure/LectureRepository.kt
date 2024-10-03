package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity

interface LectureRepository {
    fun getLecture(query: LectureQueryDto): LectureEntity
    fun getAvailableLectures(): List<LectureEntity>

    fun enroll(command: LectureEntity): LectureEntity

}