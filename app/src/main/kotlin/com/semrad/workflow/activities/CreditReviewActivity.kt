package com.semrad.workflow.activities

import com.semrad.credit.CreditReservationResult
import com.semrad.order.Order
import io.temporal.activity.ActivityInterface

@ActivityInterface
interface CreditReviewActivity {

    fun  validateAndReserveCredit(order: Order) : CreditReservationResult?

    fun submitCreditReview(order : Order, wfID: String, runID: String)
}