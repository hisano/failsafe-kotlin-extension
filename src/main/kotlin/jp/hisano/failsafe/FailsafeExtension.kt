package jp.hisano.jp.hisano.failsafe

import dev.failsafe.ExecutionContext
import dev.failsafe.Failsafe.with
import dev.failsafe.Policy

fun <R> failsafe(vararg policies: Policy<R>, block: ExecutionContext<R>.() -> R): R = with(policies.toList()).invoke(block)
