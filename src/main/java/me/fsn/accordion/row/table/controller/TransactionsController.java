package me.fsn.accordion.row.table.controller;

import me.fsn.accordion.row.table.model.Transaction;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static java.util.Objects.isNull;

@Named
public class TransactionsController {

    private Collection<Transaction> transactions;

    @PostConstruct
    public void init() {
        transactions = new ArrayList<>();

        final Transaction firstTransacion = Transaction.of(
                LocalDate.of(2019, 04, 17),
                "DESCRIPTION 1",
                10.00D
        );

        final Transaction secondTransaction = Transaction.of(
                LocalDate.of(2019, 04, 18),
                "DESCRIPTION 2",
                15.00D
        );

        final Transaction thirdTransaction = Transaction.of(
                LocalDate.of(2019, 04, 19),
                "DESCRIPTION 3",
                20.00D
        );

        transactions.addAll(Arrays.asList(
                firstTransacion,
                secondTransaction,
                thirdTransaction
        ));
    }

    public Collection<Transaction> getTransactions() {
        if (isNull(transactions) || transactions.isEmpty()) {
            transactions = new ArrayList<>();
        }

        return transactions;
    }
}
