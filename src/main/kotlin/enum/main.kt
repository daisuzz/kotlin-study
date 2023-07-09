package enum

import java.util.EnumSet

fun main() {
    val enum = Sample.A
    val map = map((enum as Enum<*>)::class.java)
    println(map.values.map { it.ordinal })
}


fun <E : Enum<E>> map(clazz: Class<E>): Map<String, E> {
    return EnumSet.allOf(clazz).associateBy { it.name }
}
