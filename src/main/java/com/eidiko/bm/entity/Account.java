package com.eidiko.bm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(length = 10, unique = true, nullable = false)
    private String mobileNumber;

    @Column(unique = true, nullable = false)
    private String emailId;

    @Column(length = 11)
    private Long accountNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String password;
}
