package com.yape.transactionservice.domain.events;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionCreatedEvent(UUID transactionId,
                                      BigDecimal value) {
}
