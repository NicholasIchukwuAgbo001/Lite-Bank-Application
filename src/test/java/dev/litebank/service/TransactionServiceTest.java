package dev.litebank.service;


import dev.litebank.dto.request.CreateTransactionRequest;
import dev.litebank.dto.request.TransactionType;
import dev.litebank.dto.response.CreateTransactionResponse;
import dev.litebank.dto.response.TransactionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;

    @Test
    void testCanCreateTransaction(){
        CreateTransactionRequest transactionRequest = new CreateTransactionRequest();
        transactionRequest.setTransactionType(TransactionType.CREDIT);
        transactionRequest.setAccountNumber("0123456789");
        transactionRequest.setAmount(new BigDecimal(20_000));

        CreateTransactionResponse transactionResponse =
                transactionService.create(transactionRequest);
        assertNotNull(transactionResponse);
        TransactionResponse transaction =
                transactionService.getTransactionBy(transactionResponse.getId());
        assertThat(transaction).isNotNull();
        assertThat(transaction.getAmount())
                .isEqualTo(transactionRequest.getAmount().toString());
    }

}
