sealed class Page {

    object TOP : Page() {
        override fun pageInfo(): List<String> {
            return emptyList()
        }
    }

    data class User(val userId: String, val name: String, val age: Int) : Page() {
        override fun pageInfo(): List<String> {
            return listOf(userId, name, age.toString())
        }
    }

    data class Item(val itemId: String, val name: String, val price: Int) : Page() {
        override fun pageInfo(): List<String> {
            return listOf(itemId, name, price.toString())
        }
    }

    data class Cart(val userId: String, val itemIds: List<String>) : Page() {
        override fun pageInfo(): List<String> {
            return listOf(userId) + itemIds
        }
    }

    abstract fun pageInfo(): List<String>
}

fun main() {
    val top = Page.TOP
    val user = Page.User("user1", "alice", 20)
    val item = Page.Item("item1", "coffee", 200)
    val cart = Page.Cart("user1", listOf("item1"))

    println(top.pageInfo())
    println(user.pageInfo())
    println(item.pageInfo())
    println(cart.pageInfo())
}
