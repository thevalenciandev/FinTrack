package com.thevalenciandev.fintrack.transaction.history;

import com.thevalenciandev.fintrack.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/transactions")
public final class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions(@RequestParam(required = false) String category) {
        if (category == null) {
            return transactionService.getTransactions();
        } else {
            return transactionService.getTransactions(category);
        }
    }

    @PostMapping
    public void uploadTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
    }

    @DeleteMapping(path = "{transactionId}")
    public void deleteTransaction(@PathVariable("transactionId") Long id) {
        transactionService.removeTransaction(id);
    }

    @PutMapping(path = "{transactionId}")
    public void amendTransaction(@PathVariable("transactionId") Long id,
                                 @RequestParam String category) {
        transactionService.updateTransaction(id, category);
    }
}
