package com.semrad.workflow.impl

import com.semrad.order.Order
import com.semrad.workflow.OrderWorkflow
import com.semrad.workflow.activities.FraudActivity
import io.temporal.activity.ActivityOptions
import io.temporal.common.RetryOptions
import io.temporal.workflow.Workflow
import java.time.Duration

class OrderWorkflowImpl : OrderWorkflow {
    override fun ProcessOrder(order: Order): Order {
        val checkOrderFraudlent = fraudActivity.CheckOrderFraudlent(order)
        if (checkOrderFraudlent.fraudDecision) {

        }
        TODO("Not yet implemented")
    }

    val fraudActivity: FraudActivity
    val retryOptions: RetryOptions

    init {
        retryOptions =
            RetryOptions.newBuilder()
                .setInitialInterval(Duration.ofSeconds(1))
                .setBackoffCoefficient(2.0)
                .setMaximumInterval(Duration.ofMinutes(2))
                .setMaximumAttempts(0)
                .build()
        var options: ActivityOptions
        ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofMinutes(5))
            .setRetryOptions(retryOptions)
            .build().also { options = it };

        fraudActivity = Workflow.newActivityStub(
            FraudActivity::class.java, ActivityOptions.newBuilder()
                .setTaskQueue("FRAUD_TASK_QUEUE")
                .setStartToCloseTimeout(Duration.ofMinutes(5))
                .setRetryOptions(retryOptions)
                .build()
        )
    }
}