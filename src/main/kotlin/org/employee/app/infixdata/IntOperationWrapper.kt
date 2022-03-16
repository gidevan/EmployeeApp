package org.employee.app.infixdata

import java.lang.IllegalArgumentException

class IntOperationWrapper(val value : Int) {

    infix fun pow(pow : IntOperationWrapper) : Int {
        if (pow.value < 0) {
            throw IllegalArgumentException("Argument is [${pow.value}]. Only positive values are supported")
        }
        if (pow.value == 0) return 1
        var result = 1
        for (i in 1..pow.value) {
            result *= value
        }
        return result
    }
}
