package com.semrad.order.fraud

import java.time.Instant
import java.util.Date
import kotlin.concurrent.fixedRateTimer

class FraudDecision {
    var fraudDecision: Boolean = false
        get() {
            return field
        }
        set(decision: Boolean) {
            field = decision
        }
    var rejectionReason: String? = null
        get() {
            return field
        }
        set(value: String?) {
            field = value
        }

    var checkDate: Instant? = null
        get() {
            return field
        }
        set(value: Instant?) {
            field = value
        }
}