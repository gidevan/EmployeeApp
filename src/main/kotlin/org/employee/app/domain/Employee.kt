package org.employee.app.domain


class Employee(firstName: String, lastName: String, val age: Int) : Person(firstName, lastName) {
    val id: String?

    init {
        id = "${firstName}_${lastName}"
    }
}
