package com.mitrais.transactionservice.controller;

import com.mitrais.transactionservice.client.MemberServiceProxy;
import com.mitrais.transactionservice.domain.Member;
import com.mitrais.transactionservice.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MemberServiceProxy serviceProxy;

    @GetMapping
    public ResponseEntity<Transaction> getTransaction() {
        Member member = restTemplate.getForEntity("http://localhost:8081/api/member", Member.class).getBody();
        Transaction transaction = new Transaction(1l, member.getName(), TransactionType.WITHDRAW);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/feign")
    public ResponseEntity<Transaction> getTransactionByFeign() {
        Member member = serviceProxy.getAllMember();
        Transaction transaction = new Transaction(1l, member.getName(), TransactionType.WITHDRAW);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}
