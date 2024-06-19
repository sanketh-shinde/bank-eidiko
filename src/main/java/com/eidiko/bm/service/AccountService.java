package com.eidiko.bm.service;

import com.eidiko.bm.entity.Account;

public interface AccountService {

    Account registerAccount(Account account);

    Account loginUsingMobileNumberAndPassword(String mobileNumber, String password);
}
