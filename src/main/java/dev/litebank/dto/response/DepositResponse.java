package dev.litebank.dto.response;

import dev.litebank.dto.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositResponse {
    private TransactionStatus transactionStatus;
    private String transactionId;
    private BigDecimal amount;
}
