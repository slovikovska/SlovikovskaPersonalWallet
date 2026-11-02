package com.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class Transaction {
    private final TransactionType type;
    private final Category category;
    private final BigDecimal amount;
    private final String description;
    private final LocalDateTime timestamp;

    // constructors
    public Transaction(TransactionType type, Category category, BigDecimal amount) {
        this(type, category, amount, null);
    }

    public Transaction(TransactionType type, Category category, BigDecimal amount, String description) {
        this.type = type;
        this.category = category;
        this.amount = checkAmount(amount);
        this.description = description;
        this.timestamp = LocalDateTime.now(ZoneId.systemDefault());
    }

    public TransactionType getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    private BigDecimal checkAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return type == that.type && category == that.category && Objects.equals(amount, that.amount) && Objects.equals(description, that.description) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, category, amount, description, timestamp);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", category=" + category +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
