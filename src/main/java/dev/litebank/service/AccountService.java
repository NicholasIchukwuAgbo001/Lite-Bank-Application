package dev.litebank.service;

import dev.litebank.dto.request.DepositRequest;
import dev.litebank.dto.response.DepositResponse;

public interface AccountService {
    DepositResponse deposit(DepositRequest depositRequest);
}
