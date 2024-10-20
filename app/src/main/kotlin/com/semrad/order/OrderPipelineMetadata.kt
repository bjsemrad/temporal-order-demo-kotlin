package com.semrad.order

class OrderPipelineMetadata {
    var fraudReview: OrderFraudReview? = null
    var creditReview: OrderCreditReview? = null
    var statusHistory: MutableList<OrderStatusHistory>? = null

    init {
        statusHistory = MutableList(5) { OrderStatusHistory() }
    }
}
