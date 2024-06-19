package com.eidiko.bm.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDTO {
    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String emailId;

    private Long accountNumber;

    private String address;

    private double amount;

}