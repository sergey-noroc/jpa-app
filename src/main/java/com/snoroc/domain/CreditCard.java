package com.snoroc.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "number")
    private String number;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "balance")
    private int balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "credit_type")
    private CreditType creditType;

    @Column(name = "is_active")
    private boolean isActive;
}
