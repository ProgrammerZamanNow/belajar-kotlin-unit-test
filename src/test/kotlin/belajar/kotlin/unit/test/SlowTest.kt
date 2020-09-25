package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

class SlowTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow(){
        Thread.sleep(10_000)
    }

}