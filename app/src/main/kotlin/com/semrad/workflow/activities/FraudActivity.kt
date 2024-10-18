package com.semrad.workflow.activities

import com.semrad.order.Order
import com.semrad.order.fraud.FraudDecision
import io.temporal.activity.ActivityInterface

@ActivityInterface
interface FraudActivity {

    fun CheckOrderFraudlent(order: Order) : FraudDecision;
}