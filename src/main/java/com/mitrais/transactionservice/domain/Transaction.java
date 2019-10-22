package com.mitrais.transactionservice.domain;

import com.mitrais.transactionservice.controller.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private long id;
    private String memberName;
    private TransactionType transactionType;
}
