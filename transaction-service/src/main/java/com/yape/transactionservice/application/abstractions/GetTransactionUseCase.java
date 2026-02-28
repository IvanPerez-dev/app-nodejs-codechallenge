package com.yape.transactionservice.application.abstractions;

import com.yape.transactionservice.application.usecases.gettransaction.GetTransactionRequest;
import com.yape.transactionservice.application.usecases.gettransaction.GetTransactionResponse;

public interface GetTransactionUseCase {
    GetTransactionResponse execute(GetTransactionRequest request);
}
