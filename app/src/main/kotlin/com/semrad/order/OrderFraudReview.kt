package com.semrad.order

import java.time.Instant

class OrderFraudReview {
    var fraudDetected: Boolean = false
    var rejectionReason: String? = null
    var decisionDate: Instant? = null
}
