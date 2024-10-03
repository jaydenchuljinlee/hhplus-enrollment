package com.hhplus.enrollment.user.infrastructure.jpa.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tutor")
data class TutorTable(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(nullable = false, name= "name")
    var name: String,
    @Column(nullable = false, name= "description")
    var description: String,
    @Column(nullable = false, name= "phone_number")
    var phoneNumber: String,
    @Column(nullable = false, name= "email")
    var email: String,

    @Column(nullable = false, name = "created_at")
    var createdAt: LocalDateTime,
    @Column(nullable = false, name = "updated_at")
    var updatedAt: LocalDateTime,
    @Column(nullable = false, name = "use_yn")
    var useYn: Char = 'Y',
)