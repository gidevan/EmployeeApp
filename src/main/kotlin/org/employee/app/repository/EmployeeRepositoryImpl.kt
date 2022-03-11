package org.employee.app.repository

import org.employee.app.domain.Employee

const val FIRST_NAME_PREFIX = "FirstName_";
const val LAST_NAME_PREFIX = "LastName_";
class EmployeeRepositoryImpl : EmployeeRepository {


    val EMPLOYEE_COUNT: Int = 5
    private val employees = mutableListOf<Employee>();
    init {
        for(i in 1..EMPLOYEE_COUNT) {
            employees.add(Employee(FIRST_NAME_PREFIX + i, LAST_NAME_PREFIX + i, i*2))
        }
    }

    override fun findEmployees(): List<Employee> {
        return employees
    }

    override fun findEmployee(id: String): Employee {
        return employees.filter { it.id == id }.first()
    }
}
