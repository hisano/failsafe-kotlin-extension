# Kotlin extension for Failsafe

`Kotlin extension for Failsafe` is an add-on to the [Failsafe](https://failsafe.dev/) library in [Kotlin](https://kotlinlang.org/).

## Example

```kotlin
import dev.failsafe.RetryPolicy
import jp.hisano.failsafe.*
import java.io.IOException
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    val retry = RetryPolicy.builder<Int>().withMaxRetries(3).withDelay(100.milliseconds).build()
    val result = retry {
        println("attemptCount = $attemptCount")
        if (attemptCount == 3) {
            1 + 2
        } else {
            throw IOException()
        }
    }
    println("result = $result")
}
```

## License

Copyright Koji Hisano. Released under the [Apache 2.0 license](https://github.com/failsafe-lib/failsafe/blob/master/LICENSE).
