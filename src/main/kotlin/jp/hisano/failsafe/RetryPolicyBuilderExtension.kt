package jp.hisano.failsafe

import dev.failsafe.RetryPolicyBuilder
import kotlin.time.Duration
import kotlin.time.toJavaDuration

fun <R> RetryPolicyBuilder<R>.withBackoff(delay: Duration, maxDelay: Duration, delayFactor: Double = 2.0): RetryPolicyBuilder<R> = withBackoff(delay.toJavaDuration(), maxDelay.toJavaDuration(), delayFactor)

fun <R> RetryPolicyBuilder<R>.withDelay(delay: Duration): RetryPolicyBuilder<R> = withDelay(delay.toJavaDuration())

fun <R> RetryPolicyBuilder<R>.withDelay(delayMin: Duration, delayMax: Duration): RetryPolicyBuilder<R> = withDelay(delayMin.toJavaDuration(), delayMax.toJavaDuration())

fun <R> RetryPolicyBuilder<R>.withJitter(jitter: Duration): RetryPolicyBuilder<R> = withJitter(jitter.toJavaDuration())

fun <R> RetryPolicyBuilder<R>.withMaxDuration(maxDuration: Duration): RetryPolicyBuilder<R> = withMaxDuration(maxDuration.toJavaDuration())
