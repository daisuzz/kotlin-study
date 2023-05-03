package collection

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val reducedSum = numbers.reduce { sum, n -> sum + n }
    println(reducedSum)

    val foldedSum = numbers.fold(0) { sum, n -> sum + n }
    println(foldedSum)

    val numbers2 = listOf(-1, -2, -3, -4, -5)
    val result = numbers.zip(numbers2)
    println(result)
}
