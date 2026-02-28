package com.yape.transactionservice.domain.models;

import com.yape.transactionservice.domain.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private UUID transactionExternalId;
    private UUID accountExternalIdDebit;
    private UUID accountExternalIdCredit;
    private Integer transferTypeId;
    private BigDecimal value;
    private TransactionStatus status;
    private LocalDateTime createdAt;

    public static Transaction Create(UUID idDebit, UUID idCredit, Integer transferTypeId, BigDecimal value) {
        return Transaction.builder().transactionExternalId(UUID.randomUUID())
                .accountExternalIdCredit(idCredit)
                .accountExternalIdDebit(idDebit)
                .transferTypeId(transferTypeId)
                .value(value)
                .status(TransactionStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

    }

    public void approve() {
        this.status = TransactionStatus.APPROVED;
    }

    public void reject() {
        this.status = TransactionStatus.REJECTED;
    }
}
