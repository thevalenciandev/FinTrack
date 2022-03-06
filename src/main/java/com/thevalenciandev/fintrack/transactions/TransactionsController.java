package com.thevalenciandev.fintrack.transactions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class TransactionsController {

    @GetMapping
    public List<Transaction> getTransactions() {
        return List.of(new Transaction(
                LocalDate.of(2022, 3, 6),
                "CARD PAYMENT TO TFL TRAVEL ON 28-01-2022",
                BigDecimal.valueOf(-4.5),
                BigDecimal.valueOf(1234.56)));
    }
}
