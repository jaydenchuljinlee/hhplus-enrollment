package com.hhplus.enrollment.lecture.infrastructure.jpa.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "enrollment_history")
@Entity
data class LectureHistoryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    @Column(name = "trainee_id", nullable = false)
    var traineeId: Long,
    @Column(name = "lecture_id", nullable = false)
    var lectureId: Long,
    @Column(name = "accept_yn", nullable = false)
    var acceptYn: Char = 'Y',
    @Column(name = "cancel_yn", nullable = false)
    var cancelYn: Char = 'N',

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "use_yn", nullable = false)
    var useYn: Char = 'Y'
)