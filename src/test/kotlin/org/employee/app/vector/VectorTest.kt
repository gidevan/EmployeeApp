package org.employee.app.vector

import kotlin.test.Test
import kotlin.test.assertEquals

class VectorTest {

    @Test
    fun testPlus() {
        val v1 = Vector(1,2)
        val v2 = Vector(2,2)
        val v3 = v1 + v2
        assertEquals(v1.x + v2.x, v3.x)
        assertEquals(v1.y + v2.y, v3.y)
    }

    @Test
    fun testMinus() {
        val v1 = Vector(1,2)
        val v2 = Vector(2,2)
        val v3 = v1 - v2
        assertEquals(v1.x - v2.x, v3.x)
        assertEquals(v1.y - v2.y, v3.y)
    }
}
