package com.yape.transactionservice.application.usecases.createtransaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionRequest(@NotNull(message = "accountExternalIdDebit is required")
                                       UUID accountExternalIdDebit,
                                       @NotNull(message = "accountExternalIdCredit is required")
                                       UUID accountExternalIdCredit,
                                       @NotNull(message = "tranferTypeId is required")
                                       Integer transferTypeId,
                                       @NotNull(message = "value is required")
                                       @Positive(message = "value must be greater than 0")
                                       BigDecimal value
) {
}










