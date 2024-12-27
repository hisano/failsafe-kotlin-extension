package jp.hisano.failsafe

import dev.failsafe.RetryPolicy
import jp.hisano.jp.hisano.failsafe.failsafe
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class FailsafeExtensionTest {
    @Test
    fun testFailsafe() {
        val retryPolicy = RetryPolicy.builder<Boolean>().withMaxRetries(5).build()

        val result = failsafe(retryPolicy) {
            if (5 <= attemptCount) {
                true
            } else {
                throw IllegalStateException()
            }
        }

        assertTrue(result)
    }
}
