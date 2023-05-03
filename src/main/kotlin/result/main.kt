package result

fun fetchData(raise: Boolean): Result<String> {
    return if (raise) {
        Result.failure(RuntimeException("raise exception"))
    } else {
        Result.success("Success!")
    }
}

fun main() {
    val result = fetchData(false)
    result.fold(
        onSuccess = { println(it) },
        onFailure = { println(it.message) },
    )
    val result2 = fetchData(true)
    result2.fold(
        onSuccess = { println(it) },
        onFailure = { println(it.message) },
    )
}
