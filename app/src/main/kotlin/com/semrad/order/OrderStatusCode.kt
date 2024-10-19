package com.semrad.order


enum class OrderStatusCode(code: String) {
    Submitted("submitted"),
    PendingFraudReview("pending-fraud"),
    NoFraudDetected("no-fraud"),
    Fraudlent("fraud"),

    PendingCreditReview("pending-credit-review"),
    CreditReviewApproved("credit-review-approved"),
    CreditReviewDenied("credit-review-denied"),

    ApprovalRequired("approval-required"),
    Approved("approved"),
    Rejected("rejected"),
    Canceled("canceled"),

    ReadyForFullfilment("ready-for-fulfillment"),
    FullfilmentConfirmed("fulfillment-confirmed");

    companion object {
        fun TerminalOrderStatus(status: OrderStatusCode): Boolean {
            when (status) {
                Fraudlent, CreditReviewDenied, Rejected, Canceled -> return true
                else -> return false
            }
        }
    }
}