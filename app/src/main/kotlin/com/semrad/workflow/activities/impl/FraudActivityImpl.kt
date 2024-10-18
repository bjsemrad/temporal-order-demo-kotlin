package com.semrad.workflow.activities.impl

import com.semrad.order.Order
import com.semrad.order.fraud.FraudClient
import com.semrad.workflow.activities.FraudActivity
import com.semrad.order.fraud.FraudDecision

class FraudActivityImpl : FraudActivity {
    
    override fun CheckOrderFraudlent(order: Order): FraudDecision {
        var fraudClient = FraudClient()
        return fraudClient.ValidateOrder(order)
    }
}