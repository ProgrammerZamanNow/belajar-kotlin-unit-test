package belajar.kotlin.unit.test

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class NestedTest {

    @Test
    fun test1(){

    }

    @Nested
    inner class MyNestedTest {

        @Test
        fun test1(){

        }

    }

}