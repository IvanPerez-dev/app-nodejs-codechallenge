package com.yape.transactionservice.application.abstractions;

import com.yape.transactionservice.domain.models.Transaction;

public interface TransactionEventListener {

    void onTransactionStatusApproved(Transaction transaction);

    void onTransactionStatusRejected(Transaction transaction);
}
