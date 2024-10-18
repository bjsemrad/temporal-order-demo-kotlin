package com.semrad.order.activities.impl

import com.semrad.order.Order
import com.semrad.order.activities.FraudActivity
import com.semrad.order.fraud.FraudDecision

class FraudActivityImpl : FraudActivity {
    
    override fun CheckOrderFraudlent(order: Order): FraudDecision {
        TODO("Not yet implemented")
    }
}