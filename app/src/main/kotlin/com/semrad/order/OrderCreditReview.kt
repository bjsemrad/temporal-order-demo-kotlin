package com.semrad.order

import java.time.Instant

class OrderCreditReview() {
    var creditAvailable: Boolean = false
    var availableCredit: Double = 0.0
    var newLimit: Double? = null
    var creditDecision : String? = null
    var reviewier : String? = null
    var decisionDate : Instant? = null
}
