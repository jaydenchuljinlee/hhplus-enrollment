package com.hhplus.enrollment.lecture.infrastructure.dto

import java.time.LocalDateTime

data class LectureCommandDto(
    var id: Long,
    var lectureId: Long,
    var traineeId: Long,
    var capacity: Long,
    var data: LocalDateTime,
)