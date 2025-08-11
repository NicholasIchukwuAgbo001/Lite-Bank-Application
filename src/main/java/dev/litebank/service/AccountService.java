package dev.litebank.service;

import dev.litebank.dto.DepositRequest;
import dev.litebank.dto.DepositResponse;

public interface AccountService {
    DepositResponse deposit(DepositRequest depositRequest);
}
