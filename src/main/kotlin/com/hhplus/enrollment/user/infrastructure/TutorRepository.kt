package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.infrastructure.dto.TutorDto
import com.hhplus.enrollment.user.infrastructure.dto.TutorQueryDto

interface TutorRepository {
    fun getTutor(query: TutorQueryDto): TutorDto
    fun getTutors(queryList: List<TutorQueryDto>): List<TutorDto>
}