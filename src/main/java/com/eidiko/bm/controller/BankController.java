package com.eidiko.bm.controller;

import com.eidiko.bm.dto.AccountDTO;
import com.eidiko.bm.entity.Account;
import com.eidiko.bm.response.CommonResponse;
import com.eidiko.bm.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<CommonResponse<?>> register(@RequestBody Account account) {
        Account savedAccount = accountService.registerAccount(account);
        CommonResponse<AccountDTO> response = new CommonResponse<>();
        if (savedAccount == null) {
            response.setMessage("Registration Failed");
            response.setStatus("Failed");
            response.setCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<CommonResponse<?>>(response, HttpStatus.BAD_REQUEST);
        }
        else {
            response.setMessage("Registration Successful");
            response.setCode(HttpStatus.CREATED.value());
            response.setStatus("Success");
            response.setResult(modelMapper.map(savedAccount, AccountDTO.class));
            return new ResponseEntity<CommonResponse<?>>(response, HttpStatus.CREATED);
        }
    }

    @GetMapping("/login/{mobileNumber}/{password}")
    public ResponseEntity<CommonResponse<?>> loginByMobileNumberAndPassword(@PathVariable String mobileNumber, @PathVariable String password) {
        Account account = accountService.loginUsingMobileNumberAndPassword(mobileNumber, password);
        CommonResponse<AccountDTO> response = new CommonResponse<>();
        if (account != null) {
            response.setMessage("Logged In Successfully");
            response.setStatus("Success");
            response.setCode(HttpStatus.OK.value());
            response.setResult(modelMapper.map(account, AccountDTO.class));
            return new ResponseEntity<CommonResponse<?>>(response, HttpStatus.OK);
        }
        else {
            response.setMessage("Log In Failed");
            response.setStatus("Failed");
            response.setCode(HttpStatus.OK.value());
            response.setResult(null);
            return new ResponseEntity<CommonResponse<?>>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
