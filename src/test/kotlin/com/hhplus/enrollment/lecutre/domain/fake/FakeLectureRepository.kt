package com.hhplus.enrollment.lecutre.domain.fake

import com.hhplus.enrollment.lecture.exception.LectureNotFoundException
import com.hhplus.enrollment.lecture.infrastructure.LectureRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import java.time.LocalDateTime


class FakeLectureRepository: LectureRepository {
    private val table = mutableMapOf<Long, LectureEntity>()

    init {
        val NOW_PLUS_1 = LocalDateTime.now().plusDays(1)
        val NOW_PLUS_2 = LocalDateTime.now().plusDays(2)
        val NOW_PLUS_3 = LocalDateTime.now().plusDays(3)
        val NOW_MINUS_1 = LocalDateTime.now().minusDays(1)

        val LECTURE_1 = LectureEntity(1L, 1L, 1, NOW_PLUS_1, 'Y', LocalDateTime.now(), LocalDateTime.now())
        val LECTURE_2 = LectureEntity(1L, 1L, 1, NOW_PLUS_2, 'Y', LocalDateTime.now(), LocalDateTime.now())
        val LECTURE_3 = LectureEntity(1L, 1L, 1, NOW_PLUS_3, 'Y', LocalDateTime.now(), LocalDateTime.now())
        val LECTURE_4 = LectureEntity(1L, 1L, 1, NOW_MINUS_1, 'Y', LocalDateTime.now(), LocalDateTime.now())

        table[1L] = LECTURE_1
        table[2L] = LECTURE_2
        table[3L] = LECTURE_3
        table[4L] = LECTURE_4
    }

    override fun getLecture(query: LectureQueryDto): LectureEntity {
        val result = table[query.lectureId] ?: throw LectureNotFoundException()
        return result
    }

    override fun getAvailableLectures(): List<LectureEntity> {
        val results = table.values
        return results.toList()
    }

    override fun enroll(command: LectureEntity): LectureEntity {
        val lecture = table[command.id] ?: throw LectureNotFoundException()

        table[command.id] = lecture

        return lecture
    }

}