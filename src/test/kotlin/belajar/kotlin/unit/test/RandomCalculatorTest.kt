package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*

class RandomCalculatorTest : ParentCalculatorTest() {

    companion object {

        @JvmStatic
        fun parameterSource(): List<Int> {
            return listOf(10, 20, 30, 40, 50)
        }

    }

    @ParameterizedTest
    @MethodSource(value = ["parameterSource"])
    fun testWithMethodSource(value: Int){
        val result = calculator.add(value, value)
        assertEquals(value + value, result)
        println(result)
    }

    @DisplayName("Test Calculator with parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = [10, 20, 30, 40, 50])
    fun testWithParameter(value: Int) {
        val result = calculator.add(value, value)
        assertEquals(value + value, result)
        println(result)
    }

    @Test
    fun testRandom(testInfo: TestInfo, random: Random){
        val first = random.nextInt(1000)
        println(first)
        val second = random.nextInt(1000)
        println(second)

        val result = calculator.add(first, second)

        assertEquals(first + second, result)
    }

    @DisplayName("Test calculator random")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    fun testRandomRepeated(random: Random, repetitionInfo: RepetitionInfo, testInfo: TestInfo){
        println("${testInfo.displayName} ke ${repetitionInfo.currentRepetition} dari ${repetitionInfo.totalRepetitions}")
        val first = random.nextInt(1000)
        println(first)
        val second = random.nextInt(1000)
        println(second)

        val result = calculator.add(first, second)

        assertEquals(first + second, result)
    }

}