package com.semrad.workflow

import com.semrad.order.Order
import io.temporal.workflow.WorkflowInterface

@WorkflowInterface
interface OrderWorkflow {

    fun ProcessOrder(order: Order) : Order;
}