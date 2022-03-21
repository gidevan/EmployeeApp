package org.employee.app.vector

class Vector(val x: Int, val y: Int) {
    operator fun plus(a: Vector) : Vector {
        return Vector(x + a.x, y + a.y)
    }

    operator fun minus(a: Vector): Vector {
        return Vector(x - a.x, y - a.y)
    }
}
