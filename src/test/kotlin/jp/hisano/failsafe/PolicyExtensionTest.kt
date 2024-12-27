package jp.hisano.failsafe

import dev.failsafe.RetryPolicy
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class PolicyExtensionTest {
    @Test
    fun testInvoke() {
        val retry = RetryPolicy.builder<Boolean>().withMaxRetries(5).build()

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
    fun testPlus() {
        val retry = RetryPolicy.builder<Boolean>().withMaxRetries(5).build()

        val result = (RetryPolicy.ofDefaults<Boolean>() + retry) {
            if (5 <= attemptCount) {
                true
            } else {
                throw IllegalStateException()
            }
        }

        assertTrue(result)
    }
}
