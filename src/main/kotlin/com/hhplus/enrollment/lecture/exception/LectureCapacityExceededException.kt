package com.hhplus.enrollment.lecture.exception

class LectureCapacityExceededException(message: String = "강의 인원이 초과되었습니다."): LectureException(message) {
}