package com.semrad.workflow.activities.impl

import com.semrad.credit.CreditReservationResult
import com.semrad.credit.CreditReviewClient
import com.semrad.order.Order
import com.semrad.workflow.activities.CreditReviewActivity

class CreditReviewActivityImpl(var client: CreditReviewClient? = null) : CreditReviewActivity {

    override fun  validateAndReserveCredit(order: Order): CreditReservationResult? {
        println("Checking available credit on order " + order.orderNumber + ".\n\n")
        val creditResult = client?.ReserveCredit(order)
        return creditResult
    }

    override fun submitCreditReview(order : Order, wfID: String, runID: String)  {
        println("Checking available credit on order " + order.orderNumber + ".\n\n")
        client?.InitiateCreditReview(wfID, runID, order)
    }
}