package com.rbcode.solutions.action_flow.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@EqualsAndHashCode
@ToString
public class Transaction {

    private String id;                     // UUID or database-generated ID
    private String externalId;             // ID from payment provider or bank
    private String sourceSystem;           // e.g., "VISA", "PayPal", "Binance"

    private BigDecimal amount;
    private String currency;               // ISO 4217 (e.g., "USD", "EUR")
    private LocalDateTime transactionDate; // When the transaction occurred (provider timestamp)
    private LocalDateTime receivedAt;      // When it was received/processed

    private TransactionStatus status;      // e.g., PENDING, SUCCESS, FAILED
    private TransactionType type;          // e.g., PAYMENT, REFUND, TRANSFER

    private String userId;                 // Internal user ID (optional)
    private String orderId;                // Related order/invoice ID
    private String accountId;              // Related internal account

    private String paymentMethod;          // e.g., CARD, BANK_TRANSFER
    private String cardMasked;             // e.g., **** **** **** 1234
    private String providerRawPayload;     // Optional: store full JSON/XML for auditing/debug

    private String createdBy;              // SYSTEM / USER / SERVICE
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
