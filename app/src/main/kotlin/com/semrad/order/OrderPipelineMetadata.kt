package com.semrad.order

class OrderPipelineMetadata {
    var fraudReview: OrderFraudReview? = null
    var creditReview: OrderCreditReview? = null
    var statusHistory: List<OrderStatusHistory>? = null
}
