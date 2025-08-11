package dev.litebank.dto.request;

import dev.litebank.dto.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositRequest {
    private String accountNumber;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
}
