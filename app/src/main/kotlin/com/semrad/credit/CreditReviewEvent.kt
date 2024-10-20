package com.semrad.credit

import com.semrad.order.Order

class CreditReviewEvent(var workflowId: String? = null, var runId: String? = null, var order: Order? = null) {
}