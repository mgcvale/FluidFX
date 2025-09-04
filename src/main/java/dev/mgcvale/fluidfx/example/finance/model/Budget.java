
package dev.mgcvale.fluidfx.example.finance.model;

import javafx.beans.property.*;

public class Budget {
    private StringProperty category;
    private DoubleProperty budgeted;
    private DoubleProperty spent;

    public Budget(String category, double budgeted, double spent) {
        this.category = new SimpleStringProperty(category);
        this.budgeted = new SimpleDoubleProperty(budgeted);
        this.spent = new SimpleDoubleProperty(spent);
    }

    public StringProperty categoryProperty() { return category; }
    public DoubleProperty budgetedProperty() { return budgeted; }
    public DoubleProperty spentProperty() { return spent; }

    public String getCategory() { return category.get(); }
    public double getBudgeted() { return budgeted.get(); }
    public double getSpent() { return spent.get(); }

    public double getRemaining() { return getBudgeted() - getSpent(); }
    public double getPercentageUsed() { return (getSpent() / getBudgeted()) * 100; }
}
