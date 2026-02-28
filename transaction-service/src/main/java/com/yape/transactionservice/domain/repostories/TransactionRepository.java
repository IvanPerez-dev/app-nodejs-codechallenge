package com.yape.transactionservice.domain.repostories;

import com.yape.transactionservice.domain.models.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {
    Optional<Transaction> GetById(UUID id);

    Transaction Create(Transaction transaction);

    List<Transaction> GetAll();
}
