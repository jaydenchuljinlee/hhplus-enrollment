package com.hhplus.enrollment.user.domain.data

import com.hhplus.enrollment.user.infrastructure.dto.TutorQueryDto

data class TutorQueryData(
    var tutorId: Long,
) {
    init {
        require(tutorId >= 0) { "Tutor ID는 0 이상이어야 합니다."}
    }

    fun toQuery(): TutorQueryDto {
        return TutorQueryDto(tutorId)
    }
}