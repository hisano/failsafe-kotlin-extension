package jp.hisano.failsafe

import dev.failsafe.ExecutionContext
import dev.failsafe.Failsafe.with
import dev.failsafe.FailsafeExecutor
import dev.failsafe.Policy

operator fun <R> Policy<R>.invoke(block: ExecutionContext<R>.() -> R): R = with(this).invoke(block)

operator fun <R> Policy<R>.plus(block: Policy<R>): FailsafeExecutor<R> = with(this).compose(block)
