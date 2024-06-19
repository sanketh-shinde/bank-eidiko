package com.eidiko.bm.service;

import com.eidiko.bm.entity.Account;
import com.eidiko.bm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    Random random = new Random();

    @Override
    public Account registerAccount(Account account) {
        long accountNumber = (long) (random.nextDouble() * 9_000_000_000L) + 1_000_000_000L;
        account.setAccountNumber(accountNumber);
        return accountRepository.save(account);
    }

    @Override
    public Account loginUsingMobileNumberAndPassword(String mobileNumber, String password) {
        return accountRepository.findByMobileNumberAndPassword(mobileNumber, password);
    }
}
