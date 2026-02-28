package com.yape.transactionservice.application.usecases.createtransaction;

import com.yape.transactionservice.domain.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateTransactionMapper {
    @Mapping(target = "transactionExternalId", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Transaction toModel(CreateTransactionRequest request);

    CreateTransactionResponse ToDto(Transaction model);
}
