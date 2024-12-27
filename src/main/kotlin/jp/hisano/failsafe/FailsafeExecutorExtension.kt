package jp.hisano.jp.hisano.failsafe

import dev.failsafe.ExecutionContext
import dev.failsafe.FailsafeException
import dev.failsafe.FailsafeExecutor
import dev.failsafe.Policy

operator fun <R> FailsafeExecutor<R>.plus(policy: Policy<R>): FailsafeExecutor<R> = compose(policy)

operator fun <R> FailsafeExecutor<R>.plus(failsafeExecutor: FailsafeExecutor<R>): FailsafeExecutor<R> {
    return failsafeExecutor.policies.fold(this) { accumulator, element ->
        accumulator.compose(element)
    }
}

operator fun <R> FailsafeExecutor<R>.invoke(block: ExecutionContext<R>.() -> R): R {
    try {
        return get { context -> context.block() }
    } catch (e: FailsafeException) {
        throw e.cause as Throwable
    }
}
