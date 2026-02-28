package com.yape.transactionservice.application.usecases.createtransaction;

import com.yape.transactionservice.application.abstractions.CreateTransactionUseCase;
import com.yape.transactionservice.domain.models.Transaction;
import com.yape.transactionservice.domain.repostories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionHandler implements CreateTransactionUseCase {
    private final CreateTransactionMapper mapper;
    private final TransactionRepository repository;

    public CreateTransactionHandler(CreateTransactionMapper mapper,
                                    TransactionRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public CreateTransactionResponse execute(CreateTransactionRequest request) {
        Transaction transaction = Transaction.Create(
                request.accountExternalIdDebit(),
                request.accountExternalIdCredit(),
                request.transferTypeId(),
                request.value()
        );

        var transactionCreated = repository.create(transaction);
        return mapper.ToDto(transactionCreated);
    }
}
