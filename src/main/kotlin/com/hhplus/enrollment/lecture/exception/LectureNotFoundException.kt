package com.hhplus.enrollment.lecture.exception

class LectureNotFoundException(message: String = "강의 정보를 찾을 수 없습니다."): LectureException(message) {
}