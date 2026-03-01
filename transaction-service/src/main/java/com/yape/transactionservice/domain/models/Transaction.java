package com.yape.transactionservice.domain.models;

import com.yape.transactionservice.domain.enums.TransactionStatus;
import com.yape.transactionservice.domain.exceptions.DomainException;
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

    public static Transaction Create(UUID debitId, UUID creditId, Integer transferTypeId, BigDecimal value) {

        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw  new DomainException("Value must be greater than zero");
        }

        if (debitId == null || debitId.equals(new UUID(0L,0L))) {
            throw  new DomainException("credit id can't be empty ");
        }

        if (creditId == null || creditId.equals(new UUID(0L,0L))) {
            throw  new DomainException("credit id can't be empty ");
        }
        if (transferTypeId.equals(0)) {
            throw  new DomainException("transferTypeId must be greater than zero");
        }

        return Transaction.builder().transactionExternalId(UUID.randomUUID())
                          .accountExternalIdCredit(creditId)
                          .accountExternalIdDebit(debitId)
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

    public void changeStatus(TransactionStatus status) {
        this.status = status;
    }
}
