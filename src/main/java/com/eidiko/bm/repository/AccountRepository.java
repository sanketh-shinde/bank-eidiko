package com.eidiko.bm.repository;

import com.eidiko.bm.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByMobileNumberAndPassword(String mobileNumber, String password);
}
