package enum

import java.util.*

fun main() {
    val enum = Sample.A
    val map = run((enum as Enum<*>)::class.java)
    println(map.values.map { it.ordinal })
}


fun <E : Enum<E>> run(clazz: Class<E>): Map<String, E> {
    println(clazz)
    return EnumSet.allOf(clazz).associateBy { it.name }
}
