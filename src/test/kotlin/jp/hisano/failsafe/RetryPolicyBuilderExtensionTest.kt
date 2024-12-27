package jp.hisano.failsafe

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

class RetryPolicyBuilderExtensionTest {
    @Test
    fun testWithMaxDuration() {
        val retryPolicy = buildRetryPolicy<String> {
            withMaxDuration(5.seconds)
        }
        assertEquals(5.seconds.toJavaDuration(), retryPolicy.config.maxDuration)
    }
}