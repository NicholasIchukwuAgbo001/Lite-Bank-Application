package dev.litebank.service;

import dev.litebank.dto.request.CreateTransactionRequest;
import dev.litebank.dto.response.CreateTransactionResponse;
import dev.litebank.dto.response.TransactionResponse;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public CreateTransactionResponse create(CreateTransactionRequest transactionRequest) {

        return null;
    }

    @Override
    public TransactionResponse getTransactionBy(String id) {
        return null;
    }
}
