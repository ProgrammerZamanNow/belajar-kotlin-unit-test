package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.TimeUnit

@Execution(ExecutionMode.CONCURRENT)
class SlowTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow1(){
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow2(){
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow3(){
        Thread.sleep(3000)
    }

}