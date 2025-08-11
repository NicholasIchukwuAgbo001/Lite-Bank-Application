package dev.litebank.service;

import dev.litebank.dto.request.CreateTransactionRequest;
import dev.litebank.dto.response.CreateTransactionResponse;
import dev.litebank.dto.response.TransactionResponse;

public interface TransactionService {
    CreateTransactionResponse create(CreateTransactionRequest transactionRequest);

    TransactionResponse getTransactionBy(String id);
}
