package com.hhplus.enrollment.lecture.infrastructure.jpa.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "lecture")
@Entity
data class LectureEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(nullable = false, name = "tutor_id")
    var tutorId: Long,
    @Column(nullable = false, name = "capacity")
    var capacity: Int = 0,
    @Column(nullable = false, name = "date")
    var date: LocalDateTime,
    @Column(nullable = false, name = "open_yn")
    var openYn: Char = 'Y',

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, name = "created_at")
    var createdAt: LocalDateTime,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, name = "updated_at")
    var updatedAt: LocalDateTime,
    @Column(nullable = false, name = "use_yn")
    var useYn: Char = 'Y',
)