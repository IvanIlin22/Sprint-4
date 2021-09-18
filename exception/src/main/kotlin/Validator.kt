import java.util.regex.Pattern

abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val errorList = ArrayList<ErrorCode>()

        if (value != null) {
            if (!(value.startsWith("7") || value.startsWith("8")) || !value.all { it.isDigit() }) {
                errorList.add(ErrorCode.INVALID_CHARACTER)
            }
            if (value.length != 11) {
                errorList.add(ErrorCode.INVALID_LENGTH)
            }
        }

        return errorList
    }
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val errorList = ArrayList<ErrorCode>()

        if (value != null) {
            if (!value.all { Character.UnicodeBlock.of(it) == Character.UnicodeBlock.CYRILLIC}) {
                errorList.add(ErrorCode.INVALID_CHARACTER)
            }
            if (value.length > 16) {
                errorList.add(ErrorCode.INVALID_LENGTH)
            }
        }

        return errorList
    }
}

class EmailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val errorList = ArrayList<ErrorCode>()
        val emailAddress: Pattern  = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        if (value != null) {
            if (!emailAddress.matcher(value).matches()) {
                errorList.add(ErrorCode.INVALID_CHARACTER)
            }
            if (value.length > 32) {
                errorList.add(ErrorCode.INVALID_LENGTH)
            }
        }

        return errorList
    }
}

class SnilsValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val errorList = ArrayList<ErrorCode>()

        if (value != null) {
            if (!value.all { it.isDigit() }) {
                errorList.add(ErrorCode.INVALID_CHARACTER)
            }
            if (value.length != 11) {
                errorList.add(ErrorCode.INVALID_LENGTH)
            }
            if (value.all { it.isDigit() } && !controlNumberValidate(value)) {
                errorList.add(ErrorCode.INVALID_CONTROL_NUMBER)
            }
        }

        return errorList
    }

    private fun controlNumberValidate(value: String): Boolean {
        val snilsArray = value.split("")
        val len = snilsArray.size
        val control = (snilsArray[len  - 3] + snilsArray[len - 2]).toInt()
        var result = false
        var i = 1
        var j = 9
        var sum = 0

        while (i <= 9) {
            sum += snilsArray[i].toInt() * j
            i++
            j--
        }
        sum %= 101
        if (sum < 100 && sum == control) {
            result = true
        }
        if (sum == 100 && control == 0) {
            result = true
        }

        return result
    }
}