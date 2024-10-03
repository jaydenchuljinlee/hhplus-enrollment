package com.hhplus.enrollment.lecture.controller.response

import java.time.format.DateTimeFormatter
import java.util.HashMap

data class LectureDetailResponseMap(
    val response: HashMap<String, List<LectureDetailResponse>>
) {
    companion object {
        fun from(results: List<LectureDetailResponse>): LectureDetailResponseMap {
            val groupByDate = results.groupBy { it.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) }

            return LectureDetailResponseMap(HashMap(groupByDate))
        }
    }
}