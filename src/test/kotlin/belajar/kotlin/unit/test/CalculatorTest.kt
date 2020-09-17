package belajar.kotlin.unit.test

import belajar.kotlin.unit.test.generator.SimpleDisplayNameGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assumptions.*
import org.opentest4j.TestAbortedException

@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
// @DisplayName("Test for Calculator class")
class CalculatorTest {

    companion object {

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("Sebelum semua unit test")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("Setelah semua unit test")
        }

    }

    val calculator = Calculator()

    @BeforeEach
    fun beforeEach() {
        println("Sebelum Unit Test")
    }

    @AfterEach
    fun afterEach() {
        println("Setelah Unit Test")
    }

    @Test
    // @DisplayName("Test for function Calculator.add(10, 10)")
    fun testAddSuccess() {
        println("Unit Test testAddSuccess")
        val result = calculator.add(10, 10)
        assertEquals(20, result, "Hasil harusnya 20")
    }

    @Test
    // @DisplayName("Test for function Calculator.add(20, 20)")
    fun testAddSuccess2() {
        println("Unit Test testAddSuccess2")
        val result = calculator.add(20, 20)
        assertEquals(40, result, "Hasil harus 40")
    }

    @Test
    fun testDivideSuccess() {
        println("Unit Test testDivideSuccess")
        val result = calculator.divide(100, 10)
        assertEquals(10, result)
    }

    @Test
    fun testDivideFailed() {
        println("Unit Test testDivideFailed")
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }
    }

    @Disabled("Sedang Diperbaiki")
    @Test
    fun testComingSoon() {
        // belum selesai
    }

    @Test
    fun testAborted() {
        val profile = System.getenv()["PROFILE"]
        if ("DEV" != profile) {
            throw TestAbortedException()
        }

        println("Test Not Aborted because Dev Profile")
    }

    @Test
    fun testAssumptions() {
        assumeTrue("DEV" == System.getenv()["PROFILE"])

        println("Test Not Aborted because Dev Profile")
    }

}