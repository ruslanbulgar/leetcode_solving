package com.rbcode.solutions.action_flow;

import com.rbcode.solutions.action_flow.actions.CheckIdempotencyAction;
import com.rbcode.solutions.action_flow.actions.LoadOrderAction;
import com.rbcode.solutions.action_flow.actions.NotifyCustomerAction;
import com.rbcode.solutions.action_flow.actions.ParsePayloadAction;
import com.rbcode.solutions.action_flow.actions.PublishEventAction;
import com.rbcode.solutions.action_flow.actions.SaveTransactionAction;
import com.rbcode.solutions.action_flow.actions.ValidateBusinessRulesAction;
import com.rbcode.solutions.action_flow.actions.ValidatePayloadAction;
import com.rbcode.solutions.action_flow.model.Transaction;
import com.rbcode.solutions.action_flow.model.TransactionStatus;
import com.rbcode.solutions.action_flow.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MainClass {
    public static void main(String[] args) {

        final Transaction transaction = mockTransaction();

        ActionFlow.first(new ValidatePayloadAction())
                .then(new CheckIdempotencyAction())
                .then(new ParsePayloadAction())
                .then(new LoadOrderAction())
                .then(new ValidateBusinessRulesAction())
                .then(new SaveTransactionAction())
                .then(new PublishEventAction())
                .then(new NotifyCustomerAction())
                .execute(transaction);
    }

    private static Transaction mockTransaction() {
        return Transaction.builder()
                .externalId("PAYPROV-99887766")
                .sourceSystem("Stripe")
                .amount(new BigDecimal("129.99"))
                .currency("USD")
                .transactionDate(LocalDateTime.of(2025, 5, 13, 14, 45))
                .receivedAt(LocalDateTime.now())
                .status(TransactionStatus.SUCCESS)
                .type(TransactionType.PAYMENT)
                .userId("user-abc-123")
                .orderId("order-456")
                .accountId("acct-001")
                .paymentMethod("CARD")
                .cardMasked("**** **** **** 1234")
                .providerRawPayload("{...}")
                .createdBy("SYSTEM")
                .createdAt(LocalDateTime.now().minusMinutes(1))
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
