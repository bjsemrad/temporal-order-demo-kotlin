package com.semrad.credit

import com.semrad.order.Order
import org.apache.kafka.clients.producer.Callback
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

class CreditReviewClient(var producer: KafkaProducer<String, CreditReviewEvent>) {

    fun ReserveCredit(order : Order) : CreditReservationResult {
        if(order.Total() > 1000) {
            return CreditReservationResult(false, 100.00)
        }
        return CreditReservationResult(true, 5000.00)
    }

    fun InitiateCreditReview(workflowId : String, runId: String, order: Order)  {
        var event = CreditReviewEvent(workflowId, runId, order)

        var topic = "OrderCreditReview"
        val record = ProducerRecord<String, CreditReviewEvent>(topic, event.runId, event)

        val send = producer.send(record)
        //Just ignore the result
        send.get()
    }
}