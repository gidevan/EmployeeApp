package org.employee.app.service

import org.employee.app.domain.Employee
import org.employee.app.repository.EmployeeRepository

class EmployeeServiceImpl(val employeeRepository : EmployeeRepository) : EmployeeService {

    override fun findById(id: String): Employee {
        return employeeRepository.findEmployee(id)
    }

    override fun findEmployees(): List<Employee> {
        return employeeRepository.findEmployees();
    }
}
