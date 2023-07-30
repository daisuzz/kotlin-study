package generics

fun main() {

    // 不変
    val intFoo: Foo<Int> = Foo(1)
    // Foo<Int>とFoo<Number>は不変なためコンパイルエラー
    val numFoo: Foo<Number> = intFoo

    // 共変
    val intBar: Bar<Int> = Bar(1)
    val numBar: Bar<Number> = intBar
    // 共変の場合なぜ変更(入力)が許可されないのか理解する
    numBar.value = 0.1 // numBarの実体はBar<Int>だが、doubleが代入できてしまい型安全でなくなる

    // 反変
    val intBaz: Baz<Int> = Baz(1)
    // Baz<Int>とBaz<Number>は反変なためコンパイルエラー
    // (Baz<Number>にはNumberのスーパークラスを型パラメータとして持つBazじゃないとダメ)
    val numBaz: Baz<Number> = intBaz
    // 反変の場合なぜ参照(出力)が許可されないのか理解する
    numBaz.value = 0.1
    val number: Double = numBaz.value as Double
}

class Foo<T>(var value: T)
class Bar<out T>(var value: T) //Tはoutポジションのためsetterを作ることができない

class Baz<in T>(var value: T) // Tはinポジションのためgetterを作ることができない
