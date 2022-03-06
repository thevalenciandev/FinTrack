package com.thevalenciandev.fintrack.transactions;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction(LocalDate date, String description, BigDecimal amount, BigDecimal balance) {
}
