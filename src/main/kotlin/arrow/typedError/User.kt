package arrow.typedError

import arrow.core.Either
import arrow.core.left
import arrow.core.raise.Raise
import arrow.core.raise.either
import arrow.core.raise.fold
import arrow.core.right

data class User(val id: Long)
object UserNotFound

val user: Either<UserNotFound, User> = User(1).right()

fun Raise<UserNotFound>.user() = User(1)

val res = either { user() }
fun Raise<UserNotFound>.res(): User = user.bind()

val error: Either<UserNotFound, User> = UserNotFound.left()
fun Raise<UserNotFound>.error(): User = raise(UserNotFound)
fun main() {
    when (res) {
        is Either.Left -> println("No logical failure occurred!")
        is Either.Right -> assert(res.value == User(1))
    }

    fold(
        block = { res() },
        recover = { _: UserNotFound -> println("No logical failure occurred!") },
        transform = { i: User -> assert(i == User(1)) }
    )

    when (error) {
        is Either.Left -> assert(error.value == UserNotFound)
        is Either.Right -> println("A logical failure occurred!")
    }

    fold(
        block = { error() },
        recover = { e: UserNotFound -> assert(e == UserNotFound) },
        transform = { _: User -> println("A logical failure occurred!") }
    )
}
