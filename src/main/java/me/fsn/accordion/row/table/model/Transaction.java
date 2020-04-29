package me.fsn.accordion.row.table.model;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

public class Transaction {

    private final Integer id;
    private final LocalDate date;
    private final String description;
    private final Double amount;

    private Transaction(Integer id, LocalDate date, String description, Double amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public static Transaction of(
        final Integer id,
        final LocalDate date,
        final String description,
        final Double amount
    ) {
        // TODO: implementar validação dos argumentos, antes de criar o objeto.
        return new Transaction(id, date, description, amount);
    }

    public Integer getId() {
        return id;
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
