package org.employee.app.reader

import org.employee.app.reader.employee.EmployeeCsvReader
import kotlin.test.Test
import kotlin.test.assertTrue

class EmployeeCsvReaderTest {

    @Test
    fun testReader() {
        val reader = EmployeeCsvReader();
        // val filePath = EmployeeCsvReaderTest :: class.java.getResource("resources/employee-test.csv").path;
        val filePath = EmployeeCsvReaderTest :: class.java.classLoader.getResource("employee-test.csv").path;
        if (filePath != null) {
            val employees = reader.readEntities(filePath);
            assertTrue(employees.isNotEmpty())
        } else {
            throw IllegalArgumentException("wrong filePath: [$filePath]")
        }
    }
}
