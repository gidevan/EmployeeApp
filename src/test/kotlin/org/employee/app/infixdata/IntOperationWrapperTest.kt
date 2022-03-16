package org.employee.app.infixdata

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class IntOperationWrapperTest {

    @Test
    fun testPow() {
        val a = IntOperationWrapper(2)
        val b = IntOperationWrapper(1)

        assertEquals(2, a pow b)

        assertEquals(2, a.pow(b))
    }

    @Test
    fun testPowNegative() {
        val a = IntOperationWrapper(2)
        val b = IntOperationWrapper(-1)
        try {
            a pow b
        } catch (e: Exception) {
            assertNotNull(e.message)
            assertTrue(e.message!!.contains("Only positive values are supported"))
        }
    }
}
