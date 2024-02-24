package generics.sandbox

fun main() {
    val c = MyComparator<Vehicle>()
    val carComparator: MyComparator<Vehicle.Car> = c
    val busComparator: MyComparator<Vehicle.Bus> = c
}

class MyComparator<in T> {
    fun compare(o1: T, o2: T): Int {
        return o1.toString().compareTo(o2.toString())
    }
}

sealed class Vehicle {
    data object Car : Vehicle()
    data object Bus : Vehicle()
}


