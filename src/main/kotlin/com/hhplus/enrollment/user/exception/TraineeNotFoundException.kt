package com.hhplus.enrollment.user.exception

class TraineeNotFoundException(message: String = "수강자 정보가 존재하지 않습니다."): UserException(message) {
}