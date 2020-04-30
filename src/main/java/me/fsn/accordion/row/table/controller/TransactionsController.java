package me.fsn.accordion.row.table.controller;

import me.fsn.accordion.row.table.model.Transaction;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static java.util.Objects.isNull;

@Named
@ViewScoped
public class TransactionsController implements Serializable {

    private Collection<Transaction> transactions;

    private String selectedReceipt;

    @PostConstruct
    public void init() {
        transactions = new ArrayList<>();

        final Transaction firstTransacion = Transaction.of(
            0,
            LocalDate.of(2019, 4, 17),
            "DESCRIPTION #1",
            10.00D
        );

        final Transaction secondTransaction = Transaction.of(
            1,
            LocalDate.of(2019, 4, 18),
            "DESCRIPTION #2",
            15.00D
        );

        final Transaction thirdTransaction = Transaction.of(
            2,
            LocalDate.of(2019, 4, 19),
            "DESCRIPTION #3",
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

    public String getSelectedReceipt() {
        return selectedReceipt;
    }

    public void setSelectedReceipt(String selectedReceipt) {
        this.selectedReceipt = selectedReceipt;
    }

    public void viewReceipt(final Integer receiptId) {
        Optional<Transaction> selectedTransaction = transactions.stream()
            .filter(t -> t.getId().equals(receiptId))
            .findFirst();

        if (selectedTransaction.isPresent()) {
            final Transaction transaction = selectedTransaction.get();
            selectedReceipt = new StringBuffer()
                .append("<table class=\"table\">")

                .append("<tr>")
                .append("<th scope=\"row\" style=\"text-align: left;\">ID:</th>")
                .append("<td>")
                .append(transaction.getId())
                .append("</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<th scope=\"row\" style=\"text-align: left;\">DATE:</th>")
                .append("<td>")
                .append(transaction.getDate())
                .append("</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<th scope=\"row\" style=\"text-align: left;\">DESCRIPTION:</th>")
                .append("<td>")
                .append(transaction.getDescription())
                .append("</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<th scope=\"row\" style=\"text-align: left;\">AMOUNT:</th>")
                .append("<td>")
                .append(transaction.getAmount())
                .append("</td>")
                .append("</tr>")

                .append("</table>")
                .toString();
        }
    }



}
