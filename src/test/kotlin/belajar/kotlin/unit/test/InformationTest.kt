package belajar.kotlin.unit.test

import org.junit.jupiter.api.*

@DisplayName("Test with TestInfo")
class InformationTest {

    @Test
    @Tags(value = [
        Tag("contoh1"),
        Tag("contoh2")
    ])
    @DisplayName("sample test one")
    fun sampleTest(testInfo: TestInfo){
        println(testInfo.displayName)
        println(testInfo.tags)
        println(testInfo.testClass)
        println(testInfo.testMethod)
    }
}