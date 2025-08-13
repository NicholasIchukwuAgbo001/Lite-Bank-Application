package dev.litebank.service;

import dev.litebank.dto.TransactionStatus;
import dev.litebank.dto.request.CreateTransactionRequest;
import dev.litebank.dto.request.DepositRequest;
import dev.litebank.dto.request.TransactionType;
import dev.litebank.dto.response.DepositResponse;
import dev.litebank.exception.AccountNotFoundException;
import dev.litebank.model.Account;
import dev.litebank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;


    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        Account foundAccount = accountRepository.findByAccountNumber(depositRequest.getAccountNumber())
                                                .orElseThrow(()->new AccountNotFoundException("account not found"));
        //TODO: create transaction record
        CreateTransactionRequest transactionRequest = new CreateTransactionRequest();
        transactionRequest.setAmount(depositRequest.getAmount());
        transactionRequest.setAccountNumber(depositRequest.getAccountNumber());
        transactionRequest.setTransactionType(TransactionType.CREDIT);
        var transactionResponse = transactionService.create(transactionRequest);
        DepositResponse depositResponse = new DepositResponse();
        depositResponse.setAmount(new BigDecimal(transactionResponse.getAmount()));
        depositResponse.setTransactionId(transactionResponse.getId());
        depositResponse.setTransactionStatus(TransactionStatus.SUCCESS);
        return depositResponse;
    }
}
