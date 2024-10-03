package com.hhplus.enrollment.user.exception

class TutorNotFoundException(message: String = "강의자 정보가 존재하지 않습니다."): UserException(message) {
}