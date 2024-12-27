package jp.hisano.failsafe

import dev.failsafe.Failsafe
import dev.failsafe.RetryPolicy
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class FailsafeExecutorExtensionTest {
    @Test
    fun testInvoke() {
        val retry = Failsafe.with(RetryPolicy.builder<Boolean>().withMaxRetries(5).build())

        val result = retry {
            if (5 <= attemptCount) {
                true
            } else {
                throw IllegalStateException()
            }
        }

        assertTrue(result)
    }

    @Test
    fun testPlusPolicy() {
        val retry = RetryPolicy.builder<Boolean>().withMaxRetries(5).build()

        val result = (Failsafe.with(RetryPolicy.ofDefaults<Boolean>()) + retry) {
            if (5 <= attemptCount) {
                true
            } else {
                throw IllegalStateException()
            }
        }

        assertTrue(result)
    }

    @Test
    fun testPlusFailsafeExecutor() {
        val retry = Failsafe.with(RetryPolicy.builder<Boolean>().withMaxRetries(5).build())

        val result = (Failsafe.with(RetryPolicy.ofDefaults<Boolean>()) + retry) {
            if (5 <= attemptCount) {
                true
            } else {
                throw IllegalStateException()
            }
        }

        assertTrue(result)
    }
}
