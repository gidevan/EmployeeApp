import org.employee.app.domain.Employee
import org.employee.app.domain.Person
import org.employee.app.repository.EmployeeRepositoryImpl
import org.employee.app.service.EmployeeServiceImpl

const val TEST_FIRST_NAME_PREFIX = "FirstName_"
const val TEST_LAST_NAME_PREFIX = "LastName_"
fun main(args: Array<String>) {
    println("Hello World!")
    println("Hello World!" + args.size)

    val person1 = Person(TEST_FIRST_NAME_PREFIX + 1, TEST_LAST_NAME_PREFIX + 1)

    println("Employee.toString():$person1")
    println("fullName:" + person1.fullName)
    println("fullName:${person1.fullName}")
    println("firstName:${person1.firstName}")
    println("firstName:${person1.lastName}")

    val employee = Employee(TEST_FIRST_NAME_PREFIX + 1, TEST_FIRST_NAME_PREFIX + 1, 22);

    println("employee: [${employee.firstName}, ${employee.lastName}, ${employee.fullName},  ${employee.age}]")

    testEmployeeRepository()

}

fun testEmployeeRepository() {
    println("Test Dependency injection...")
    val employeeRepository = EmployeeRepositoryImpl()
    val employeeService = EmployeeServiceImpl(employeeRepository)

    val employees = employeeService.findEmployees();
    for (employee in employees) {
        println("employee: [${employee.id}, ${employee.firstName}, ${employee.lastName}, ${employee.age}]")
    }

}
