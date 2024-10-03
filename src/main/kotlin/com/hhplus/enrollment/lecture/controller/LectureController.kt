package com.hhplus.enrollment.lecture.controller

import com.hhplus.enrollment.lecture.usecase.LectureFacade
import com.hhplus.enrollment.lecture.controller.request.LectureHistoryRequest
import com.hhplus.enrollment.lecture.controller.request.LectureRequest
import com.hhplus.enrollment.lecture.controller.response.LectureDetailResponse
import com.hhplus.enrollment.lecture.controller.response.LectureDetailResponseMap
import com.hhplus.enrollment.lecture.controller.response.LectureHistoryResponse
import com.hhplus.enrollment.lecture.controller.response.LectureResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/lecture")
@RestController
class LectureController(
    private val lectureFacade: LectureFacade,
) {
    @PostMapping("enrollment")
    fun enroll(
        @RequestBody command: LectureRequest.Command): LectureResponse {
        val result = lectureFacade.enroll(command.toInfo())
        return LectureResponse.from(result)
    }

    @GetMapping("enrollment/histories/{traineeId}")
    fun getEnrollmentHistories(@PathVariable traineeId: Long): List<LectureHistoryResponse> {
        val query = LectureHistoryRequest.Query(traineeId)
        val results = lectureFacade.getLectureHistories(query.toInfo())
        return results.map { LectureHistoryResponse.from(it) }
    }

    @GetMapping("list")
    fun getLectureList(): LectureDetailResponseMap {
        val results = lectureFacade.getGroupedAvailableLectures()
        val toDetail = results.map { LectureDetailResponse.from(it) }

        return LectureDetailResponseMap.from(toDetail)
    }
}