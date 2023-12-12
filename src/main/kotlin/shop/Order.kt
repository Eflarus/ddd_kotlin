package shop

private val orders = mutableMapOf<String, Order>()

enum class OrderState {
    CREATED,
    PAYED,
    DELIVERED,
    COMPLETED,
    CANCELLED
}

data class Product(
    val id: Int,
    val label: String,
    val price: Double
)

data class DeliveryAddress(val street: String, val city: String, val postalCode: String) {
    init {
        require(street.isNotEmpty()) { "Адрес (улица) должен быть заполнен." }
        require(city.isNotEmpty()) { "Адрес (город) должен быть заполнен." }
        require(postalCode.isNotEmpty()) { "Адрес (индекс) должен быть заполнен." }
    }
}

data class Order(
    val id: String,
    val state: OrderState,
    val products: List<Product>,
    val deliveryAddress: DeliveryAddress
) {
    init {
        require(id.isNotBlank()) { "Идентификатор не может быть пустым" }
        require(products.isNotEmpty()) { "Заказ должен содержать хотя бы один продукт." }
    }
}

class OrderRepository {
    fun save(order: Order) {
        orders[order.id] = order
    }

    fun getOrderById(orderId: String): Order {
        return orders[orderId]!!
    }
}

class OrderFactory {
    fun createOrder(id: String, products: List<Product>, deliveryAddress: DeliveryAddress): Order {
        return Order(id, OrderState.CREATED, products, deliveryAddress)
    }
}

