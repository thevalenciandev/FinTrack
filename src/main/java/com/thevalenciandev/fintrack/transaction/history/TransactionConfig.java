package com.thevalenciandev.fintrack.transaction.history;

import com.thevalenciandev.fintrack.transaction.Transaction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner commandLineRunner(TransactionRepository transactionRepository) {
        return args -> {
            Transaction t1 = new Transaction(
                    1L,
                    LocalDate.of(2022, 3, 6),
                    "CARD PAYMENT TO TFL TRAVEL",
                    "Transport",
                    BigDecimal.valueOf(-4.5),
                    BigDecimal.valueOf(1234.56));
            Transaction t2 = new Transaction(
                    2L,
                    LocalDate.of(2022, 3, 7),
                    "DELIVEROO",
                    "Take-out",
                    BigDecimal.valueOf(-30.00),
                    BigDecimal.valueOf(1204.56));
            Transaction t3 = new Transaction(
                    3L,
                    LocalDate.of(2022, 3, 8),
                    "BAKERY",
                    "Groceries",
                    BigDecimal.valueOf(-4.56),
                    BigDecimal.valueOf(1200.0));

            transactionRepository.saveAll(List.of(t1, t2, t3));
        };
    }
}
