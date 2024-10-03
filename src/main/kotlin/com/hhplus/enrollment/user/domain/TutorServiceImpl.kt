package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.data.TutorQueryData
import com.hhplus.enrollment.user.domain.data.TutorData
import com.hhplus.enrollment.user.infrastructure.TutorRepository
import org.springframework.stereotype.Service

@Service
class TutorServiceImpl(
    private val tutorRepository: TutorRepository
): TutorService {
    override fun getTutor(tutorQueryData: TutorQueryData): TutorData {
        val result = tutorRepository.getTutor(tutorQueryData.toQuery())
        return TutorData.from(result)
    }

    override fun getTutors(paramList: List<TutorQueryData>): List<TutorData> {
        val queryList = paramList.map { it.toQuery() }
        val results = tutorRepository.getTutors(queryList)
        return results.map { TutorData.from(it) }
    }

}