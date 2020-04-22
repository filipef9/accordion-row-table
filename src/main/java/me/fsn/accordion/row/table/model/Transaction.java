package me.fsn.accordion.row.table.model;

import java.time.LocalDate;

public class Transaction {

    private final LocalDate date;
    private final String description;
    private final Double amount;

    private Transaction(LocalDate date, String description, Double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public static Transaction of(
        final LocalDate date,
        final String description,
        final Double amount
    ) {
        // TODO: implementar validação dos argumentos, antes de criar o objeto.
        return new Transaction(date, description, amount);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

}
