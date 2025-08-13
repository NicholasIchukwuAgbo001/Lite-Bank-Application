package dev.litebank.service;

import dev.litebank.dto.request.CreateTransactionRequest;
import dev.litebank.dto.response.CreateTransactionResponse;
import dev.litebank.dto.response.TransactionResponse;
import dev.litebank.model.Transaction;
import dev.litebank.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public CreateTransactionResponse create(CreateTransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionType(transactionRequest.getTransactionType());
        transaction.setAccountNumber(transactionRequest.getAccountNumber());
        transaction = transactionRepository.save(transaction);

        CreateTransactionResponse response = new CreateTransactionResponse();
        response.setId(transaction.getId());
        response.setAmount(transaction.getAmount().toString());
        response.setTransactionType(transaction.getTransactionType().toString());
        return response;
    }

    @Override
    public TransactionResponse getTransactionBy(String id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("transaction not found"));

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setAmount(transaction.getAmount().toString());
        return transactionResponse;
    }
}
