package com.yape.transactionservice.application.usecases.createtransaction;

import com.yape.transactionservice.domain.events.TransactionCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TransactionCreatedEventHandler {
    @Async
    @EventListener
    public void handle(TransactionCreatedEvent event) {
        System.out.println("Transaction created: " + event.transactionId());
    }
}
