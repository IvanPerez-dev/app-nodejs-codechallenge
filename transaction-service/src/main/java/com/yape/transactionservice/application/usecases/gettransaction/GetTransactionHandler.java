package com.yape.transactionservice.application.usecases.gettransaction;

import com.yape.transactionservice.application.abstractions.GetTransactionUseCase;
import org.springframework.stereotype.Service;

@Service
public class GetTransactionHandler implements GetTransactionUseCase {
    @Override
    public GetTransactionResponse execute(GetTransactionRequest request) {
        return null;
    }
}
