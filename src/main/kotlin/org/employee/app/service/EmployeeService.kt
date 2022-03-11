package org.employee.app.service

import org.employee.app.domain.Employee

interface EmployeeService {
    fun findById(id : String) : Employee

    fun findEmployees() : List<Employee>
}
