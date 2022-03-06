package com.thevalenciandev.fintrack.transaction.history;

import com.thevalenciandev.fintrack.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public final class TransactionService {

    public List<Transaction> getTransactions() {
        return List.of(new Transaction(
                LocalDate.of(2022, 3, 6),
                "CARD PAYMENT TO TFL TRAVEL ON 28-01-2022",
                BigDecimal.valueOf(-4.5),
                BigDecimal.valueOf(1234.56)));
    }
}
