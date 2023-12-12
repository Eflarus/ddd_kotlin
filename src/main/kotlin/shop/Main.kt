package shop

import java.util.*


fun main() {
    val orderRepository = OrderRepository()
    val buyerRepository = BuyerRepository()
    val orderFactory = OrderFactory()
    val buyerFactory = BuyerFactory()


    val newBuyer = buyerFactory.createBuyer("1", PaymentMethod.CASH, CardType.MIR)
    buyerRepository.save(newBuyer)
    val buyer = buyerRepository.getBuyerById("1")

    val deliveryAddress = DeliveryAddress("123 Main St", "City", "12345")
    val newOrder =
        orderFactory.createOrder(UUID.randomUUID().toString(), listOf(Product(33, "33", 33.0)), deliveryAddress)
    orderRepository.save(newOrder)
    val order = orderRepository.getOrderById(newOrder.id)

    println(
        "Заказ: идентификатор заказа - ${order.id}, " +
                "статус заказа - ${order.state}, " +
                "список товаров - ${order.products}, " +
                "адрес заказа - ${order.deliveryAddress}"
    )
    println(
        "Покупатель: ID - ${buyer.id}, " +
                "тип карты покупателя - ${buyer.cardType}, " +
                "метод оплаты - ${buyer.payType}"
    )
}