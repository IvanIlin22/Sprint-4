class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") {it.msg})

enum class ErrorCode(val code: Int, val msg: String) {
    INVALID_CHARACTER(100, "Недопустимый символ"),
    INVALID_LENGTH(200, "Недопустимая длинна"),
    INVALID_CONTROL_NUMBER(300, "Неверное контрольное числл")
    // ...
}