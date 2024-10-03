package com.hhplus.enrollment.lecture.exception

class LectureInPastException(message: String = "현재 이후의 강의만 신청 가능합니다."): LectureException(message) {
}