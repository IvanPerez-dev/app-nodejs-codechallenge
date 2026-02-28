package com.yape.transactionservice.presentation.controllers;

import com.yape.transactionservice.application.abstractions.CreateTransactionUseCase;
import com.yape.transactionservice.application.abstractions.GetTransactionUseCase;
import com.yape.transactionservice.application.usecases.createtransaction.CreateTransactionRequest;
import com.yape.transactionservice.application.usecases.createtransaction.CreateTransactionResponse;
import com.yape.transactionservice.application.usecases.gettransaction.GetTransactionRequest;
import com.yape.transactionservice.application.usecases.gettransaction.GetTransactionResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final CreateTransactionUseCase createTransactionUseCase;
    private final GetTransactionUseCase getTransactionUseCase;

    public TransactionController(CreateTransactionUseCase createTransactionUseCase,
                                 GetTransactionUseCase getTransactionUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
        this.getTransactionUseCase = getTransactionUseCase;
    }

    @PostMapping
    public CreateTransactionResponse CreateTransaction(@RequestBody CreateTransactionRequest request) {
        return createTransactionUseCase.execute(request);
    }

    @GetMapping
    public GetTransactionResponse GetTransaction() {
        return getTransactionUseCase.execute(new GetTransactionRequest());
    }
}
