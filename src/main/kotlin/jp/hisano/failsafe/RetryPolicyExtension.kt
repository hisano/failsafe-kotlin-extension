@file:JvmName("RetryPolicyExtension")

package jp.hisano.failsafe

import dev.failsafe.RetryPolicy
import dev.failsafe.RetryPolicyBuilder
import dev.failsafe.RetryPolicyConfig

inline fun <R> buildRetryPolicy(config: RetryPolicyConfig<R>? = null, block: RetryPolicyBuilder<R>.() -> Unit): RetryPolicy<R> = (if (config == null) RetryPolicy.builder<R>() else RetryPolicy.builder<R>(config)).apply(block).build()
