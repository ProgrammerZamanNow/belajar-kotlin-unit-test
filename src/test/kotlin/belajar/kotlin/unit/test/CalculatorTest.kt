package belajar.kotlin.unit.test

import belajar.kotlin.unit.test.generator.SimpleDisplayNameGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*

@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
// @DisplayName("Test for Calculator class")
class CalculatorTest {

    val calculator = Calculator()

    @Test
    // @DisplayName("Test for function Calculator.add(10, 10)")
    fun testAddSuccess() {
        val result = calculator.add(10, 10)
        assertEquals(20, result, "Hasil harusnya 20")
    }

    @Test
    // @DisplayName("Test for function Calculator.add(20, 20)")
    fun testAddSuccess2() {
        val result = calculator.add(20, 20)
        assertEquals(40, result, "Hasil harus 40")
    }

    @Test
    fun testDivideSuccess() {
        val result = calculator.divide(100, 10)
        assertEquals(10, result)
    }

    @Test
    fun testDivideFailed() {
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }
    }

}