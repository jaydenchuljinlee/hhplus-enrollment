package com.hhplus.enrollment.lecture.exception

class DuplicateEnrollmentException(message: String = "현재 수강한 이력이 있습니다."): LectureException(message) {
}