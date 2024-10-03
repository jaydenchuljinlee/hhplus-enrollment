package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.data.TutorQueryData
import com.hhplus.enrollment.user.domain.data.TutorData

interface TutorService {
    fun getTutor(tutorQueryData: TutorQueryData): TutorData
    fun getTutors(paramList: List<TutorQueryData>): List<TutorData>
}