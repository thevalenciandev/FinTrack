package com.thevalenciandev.fintrack.transaction.history;

import com.thevalenciandev.fintrack.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
