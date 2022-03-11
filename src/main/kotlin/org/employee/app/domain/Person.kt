package org.employee.app.domain

open class Person(val firstName: String, val lastName: String) {
    val fullName = firstName.toUpperCase() + "_" + lastName.toUpperCase()
}
