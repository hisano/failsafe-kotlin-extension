package jp.hisano.failsafe

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RetryPolicyExtensionTest {
    @Test
    fun testBuildRetryPolicy() {
        val retryPolicy = buildRetryPolicy<String> {
            withMaxRetries(3)
        }
        assertEquals(3, retryPolicy.config.maxRetries)

        val retryPolicy2 = buildRetryPolicy<String>(retryPolicy.config) {}
        assertEquals(3, retryPolicy2.config.maxRetries)
    }
}