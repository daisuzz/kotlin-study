package arrow.errorAccumulate

import arrow.core.Either
import arrow.core.NonEmptyList
import arrow.core.raise.either
import arrow.core.raise.zipOrAccumulate

class ErrorAccumulate {

    private fun getResult(raise: Boolean): Either<Throwable, String> {
        return if (raise) {
            Either.Left(RuntimeException("throw runtime exception!"))
        } else {
            Either.Right("OK")
        }
    }

    fun getResults(raise1: Boolean, raise2: Boolean): Either<NonEmptyList<Throwable>, String> {
        return either {
            zipOrAccumulate(
                { getResult(raise1).bind() },
                { getResult(raise2).bind() },
            ) { s1, s2 -> "$s1, $s2" }
        }
    }
}

fun main() {

    val ea = ErrorAccumulate()

    val results1 = ea.getResults(raise1 = false, raise2 = false)
    println(results1)

    val results2 = ea.getResults(raise1 = true, raise2 = false)
    println(results2)

    val results3 = ea.getResults(raise1 = false, raise2 = true)
    println(results3)

    val results4 = ea.getResults(raise1 = true, raise2 = true)
    println(results4)
}
