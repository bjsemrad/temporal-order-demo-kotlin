package com.semrad.order

import java.time.Instant

class Order(orderNumber: String) {
    var channel: String? = null
    var orderNumber: String? = null
    var orderStatus: OrderStatus? = null
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
        line.price =  price
        this.lines?.add(line)
    }


}


