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
                    "CARD PAYMENT TO TFL TRAVEL ON 28-01-2022",
                    "Transport",
                    BigDecimal.valueOf(-4.5),
                    BigDecimal.valueOf(1234.56));
            Transaction t2 = new Transaction(
                    2L,
                    LocalDate.of(2022, 3, 6),
                    "DELIVEROO ON 29-01-2022",
                    "Take-out",
                    BigDecimal.valueOf(-30.00),
                    BigDecimal.valueOf(1204.56));

            transactionRepository.saveAll(List.of(t1, t2));
        };
    }
}
