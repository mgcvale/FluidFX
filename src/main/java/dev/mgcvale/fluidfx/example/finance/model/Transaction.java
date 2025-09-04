
package dev.mgcvale.fluidfx.example.finance.model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Transaction {
    private StringProperty description;
    private DoubleProperty amount;
    private StringProperty category;
    private ObjectProperty<LocalDate> date;
    private BooleanProperty isIncome;

    public Transaction(String description, double amount, String category, LocalDate date, boolean isIncome) {
        this.description = new SimpleStringProperty(description);
        this.amount = new SimpleDoubleProperty(amount);
        this.category = new SimpleStringProperty(category);
        this.date = new SimpleObjectProperty<>(date);
        this.isIncome = new SimpleBooleanProperty(isIncome);
    }

    public StringProperty descriptionProperty() { return description; }
    public DoubleProperty amountProperty() { return amount; }
    public StringProperty categoryProperty() { return category; }
    public ObjectProperty<LocalDate> dateProperty() { return date; }
    public BooleanProperty isIncomeProperty() { return isIncome; }

    public String getDescription() { return description.get(); }
    public double getAmount() { return amount.get(); }
    public String getCategory() { return category.get(); }
    public LocalDate getDate() { return date.get(); }
    public boolean isIncome() { return isIncome.get(); }

    public String getFormattedAmount() {
        return String.format("%s$%.2f", isIncome() ? "+" : "-", Math.abs(getAmount()));
    }
}