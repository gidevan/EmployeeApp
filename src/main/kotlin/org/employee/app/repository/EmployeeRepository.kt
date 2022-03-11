package org.employee.app.repository

import org.employee.app.domain.Employee

interface EmployeeRepository {
    fun findEmployees() : List<Employee>

    fun findEmployee(id: String) : Employee
}
