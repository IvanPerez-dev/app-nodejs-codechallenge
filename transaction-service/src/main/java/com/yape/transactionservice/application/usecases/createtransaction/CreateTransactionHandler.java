package com.yape.transactionservice.application.usecases.createtransaction;

import com.yape.transactionservice.application.abstractions.CreateTransactionUseCase;
import com.yape.transactionservice.domain.enums.TransferType;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionHandler implements CreateTransactionUseCase {
    @Override
    public CreateTransactionResponse execute(CreateTransactionRequest request) {
        var ex = TransferType.EXTERNAL.getId();


        return null;
    }
}
