package com.snoroc.domain;

import jakarta.persistence.*;


import java.util.List;

@NamedStoredProcedureQuery(
        name = "calculate",
        procedureName = "GET_TOTAL_BALANCE_BY_CARD_TYPE",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "type"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "sum")
        }
)
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

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CreditTransaction> creditTransactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<CreditTransaction> getCreditTransactions() {
        return creditTransactions;
    }

    public void setCreditTransactions(List<CreditTransaction> creditTransactions) {
        this.creditTransactions = creditTransactions;
    }
}
