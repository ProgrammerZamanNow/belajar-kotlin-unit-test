package belajar.kotlin.unit.test

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.condition.*

class ConditionalTest {

    @Test
    @EnabledOnOs(value = [OS.WINDOWS, OS.LINUX])
    fun enabledOnWindowsOrLinux() {
        // only run on windows or linux
    }

    @Test
    @DisabledOnOs(value = [OS.WINDOWS])
    fun disabledOnWindows() {
        // can not run on windows
    }

    @Test
    @EnabledOnJre(value = [JRE.JAVA_8])
    fun onlyRunOnJava8() {

    }

    @Test
    @DisabledOnJre(value = [JRE.JAVA_8])
    fun disabledRunOnJava8() {

    }

    @Test
    fun printSystemProperties() {
        System.getProperties().forEach { key, value ->
            println("$key => $value")
        }
    }

    @Test
    @EnabledIfSystemProperties(value = [
        EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun enabledOnOracle() {

    }

    @Test
    @DisabledIfSystemProperties(value = [
        DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun disabledOnOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun enabledOnDev(){

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun disabledOnDev(){

    }

}