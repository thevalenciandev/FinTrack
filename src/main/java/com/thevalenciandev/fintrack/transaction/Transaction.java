package com.thevalenciandev.fintrack.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class Transaction {

    public enum Direction {
        IN, OUT //TODO: store in a more readable way
    }

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long id;

    private LocalDate date;
    private String description;
    private BigDecimal amount;
    private BigDecimal balance;
    private String category;
    private Direction direction;

    public Transaction() {
        // So persistence provider can instantiate objects when mapping query results
    }

    public Transaction(Long id, LocalDate date, String description, String category, BigDecimal amount, BigDecimal balance, Direction direction) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.balance = balance;
        this.direction = direction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id)
                && Objects.equals(date, that.date)
                && Objects.equals(description, that.description)
                && Objects.equals(amount, that.amount)
                && Objects.equals(balance, that.balance)
                && Objects.equals(category, that.category)
                && Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, amount, balance, category, direction);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", category='" + category + '\'' +
                ", direction=" + direction +
                '}';
    }
}
