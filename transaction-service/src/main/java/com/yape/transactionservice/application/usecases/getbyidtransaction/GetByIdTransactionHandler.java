package com.yape.transactionservice.application.usecases.getbyidtransaction;

import com.yape.transactionservice.application.abstractions.GetByIdTransactionUseCase;
import com.yape.transactionservice.domain.repostories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetByIdTransactionHandler implements GetByIdTransactionUseCase {
    private final GetByIdTransactionMapper mapper;
    private final TransactionRepository repository;

    public GetByIdTransactionHandler(GetByIdTransactionMapper mapper, TransactionRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<GetByIdTransactionResponse> execute(GetByIdTransactionRequest request) {
        var transaction = repository.getById(request.id());
        return transaction.map(mapper::toDTO);
    }
}
