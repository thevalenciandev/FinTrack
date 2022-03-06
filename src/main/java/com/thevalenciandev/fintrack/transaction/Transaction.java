package com.thevalenciandev.fintrack.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction(LocalDate date, String description, BigDecimal amount, BigDecimal balance) {
}
