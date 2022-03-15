package org.employee.app.reader.employee

import org.employee.app.domain.Employee
import org.employee.app.reader.AbstractCsvEntityReader
import java.lang.IllegalStateException

const val FIRST_NAME_HEADER = "firstName"
const val LAST_NAME_HEADER = "lastName"
const val AGE_HEADER = "age"
class EmployeeCsvReader : AbstractCsvEntityReader<Employee>() {

    override fun readEntity(entityString: String, headersMap: Map<String, Int>): Employee {
        val entityData = entityString.split(DELIMETER).toTypedArray()

        val firstName = findValue(FIRST_NAME_HEADER, entityData, headersMap);
        val lastName = findValue(LAST_NAME_HEADER, entityData, headersMap);
        val age = findValue(AGE_HEADER, entityData, headersMap);
        return Employee(firstName, lastName, age.toInt())
    }

    private fun findValue(header: String, employeeData: Array<String>, headersMap: Map<String, Int>) : String {
        val index = headersMap.get(header)
        if (index != null) {
            return employeeData.get(index)
        }
        throw IllegalStateException("Field $header is not set");
    }
}
