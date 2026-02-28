package com.yape.transactionservice.Infrastructure.persistence.repositories;

import com.yape.transactionservice.domain.models.Transaction;
import com.yape.transactionservice.domain.repostories.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    @Override
    public Optional<Transaction> GetById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Transaction Create(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> GetAll() {
        return List.of();
    }
}
