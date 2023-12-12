package shop


private val buyers = mutableMapOf<String, Buyer>()


enum class CardType {
    MIR,
    VISA,
    MASTER_CARD
}

enum class PaymentMethod {
    CASH,
    CREDIT_CARD,
    DEBIT_CARD
}


data class Buyer(val id: String, val payType: PaymentMethod, val cardType: CardType) {
    init {
        require(id.isNotBlank()) { "Идентификатор не может быть пустым." }
    }
}

class BuyerFactory {
    fun createBuyer(id: String, payType: PaymentMethod, cardType: CardType): Buyer {
        return Buyer(id, PaymentMethod.CREDIT_CARD, CardType.MIR)
    }
}

class BuyerRepository {
    fun save(buyer: Buyer) {
        buyers[buyer.id] = buyer
    }

    fun getBuyerById(buyerId: String): Buyer {
        return buyers[buyerId]!!
    }
}