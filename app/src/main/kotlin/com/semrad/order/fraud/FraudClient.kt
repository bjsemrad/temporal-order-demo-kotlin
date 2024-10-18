package com.semrad.order.fraud

import com.semrad.order.Order
import java.time.Instant

class FraudClient {

    fun ValidateOrder( order : Order) : FraudDecision {
        var result = FraudDecision()
        result.fraudDecision = false
        result.rejectionReason = ""
        result.checkDate = Instant.now()
        return result
//        if len(order.Lines) > 5 {
//            result.FraudDetected = true
//            result.RejectionReason = "Large Order"
//        }
//        return result, nil

    }
}