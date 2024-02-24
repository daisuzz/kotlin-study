package generics.basic

fun main() {

    // 不変
    val intFoo: Foo<Int> = Foo(1)
    // ↓はFoo<Int>とFoo<Number>は不変なためコンパイルエラー
    // val numFoo: Foo<Number> = intFoo

    // 共変
    val intBar: Bar<Int> = Bar(1)
    val numBar: Bar<Number> = intBar
    // 共変の場合なぜ変更(入力)が許可されないのか理解する
    // ↓はnumBarの実体はBar<Int>だが、doubleが代入できてしまう
    // numBar.value = 0.1

    // 反変
    val numBaz: Baz<Number> = Baz(1)
    val intBaz: Baz<Int> = numBaz
    // 反変の場合なぜ参照(出力)が許可されないのか理解する
    // ↓はintBazの実体はBar<Number>のため、doubleにキャストして参照できてしまう
    // val double: Double = intBaz.value as Double
}

class Foo<T>(var value: T)
class Bar<out T>(val value: T) //Tはoutポジションのためsetterを作ることができない

class Baz<in T>(private var value: T) {
    fun setValue(v: T) {
        this.value = v
    }
    // Tはinポジションのためgetterを作ることができない
}
