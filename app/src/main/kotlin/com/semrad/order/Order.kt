package com.semrad.order

import java.time.Instant

class Order(orderNumber: String) {
    var channel: String? = null
    var orderNumber: String? = null
    var status: OrderStatus? = null
    var lastUpdated: Instant? = null
    var fulfillmentOrderNumber: String? = null
    var lines: MutableList<OrderLine>? = null
    var payment: Payment? = null
    var settings: OrderSettings? = null
    var pipelineMetaData: OrderPipelineMetadata? = null

    init {
        lines = ArrayList()
        payment = Payment()
        pipelineMetaData = OrderPipelineMetadata()
    }

    fun AddLine(lineNumber: Int, product: String, quantity: Int, price: Double) {
        var line = OrderLine()
        line.lineNumber = lineNumber
        line.product = product
        line.quantity = quantity
        line.price = price
        this.lines?.add(line)
    }

    fun UpdateStatus(newStatus : OrderStatusCode, reason: String) {
        this.recordStatusChange(this.status?.code!!, this.status?.reason!!, this.lastUpdated!!)
        this.status?.code = newStatus
        this.status?.reason = reason
        this.lastUpdated = Instant.now()
    }

    fun Total() : Double {
        var total = 0.0
        for (line in lines!!) {
            total += line.price * line.quantity
        }
        return total
    }

    fun RecordCreditReservation(creditAvailable: Boolean, availableCredit: Double) {
        this.pipelineMetaData?.creditReview = OrderCreditReview()
        this.pipelineMetaData?.creditReview?.availableCredit = availableCredit
        this.pipelineMetaData?.creditReview?.creditAvailable = creditAvailable
    }

    fun RecordCreditReviewDecision(decision: String, reviewer: String, newLimit: Double, reviewDate: Instant) {
        this.pipelineMetaData?.creditReview = OrderCreditReview()
        this.pipelineMetaData?.creditReview?.creditDecision = decision
        this.pipelineMetaData?.creditReview?.reviewier = reviewer
        this.pipelineMetaData?.creditReview?.decisionDate = reviewDate
        this.pipelineMetaData?.creditReview?.newLimit = newLimit
    }

    fun RecoardFraudReviewDecision(fradulent: Boolean, reason: String, reviewDate: Instant) {
        this.pipelineMetaData?.fraudReview = OrderFraudReview()
        this.pipelineMetaData?.fraudReview?.fraudDetected = fradulent
        this.pipelineMetaData?.fraudReview?.rejectionReason = reason
        this.pipelineMetaData?.fraudReview?.decisionDate = reviewDate
    }

    fun recordStatusChange(status: OrderStatusCode, reason: String, statusDate: Instant) {
        var historyItem = OrderStatusHistory()
        this.pipelineMetaData?.statusHistory?.add(historyItem)
        historyItem.status = status
        historyItem.reason = reason
        historyItem.date = statusDate
    }

}


