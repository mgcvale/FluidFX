
package dev.mgcvale.fluidfx.example.finance.viewmodel;

import dev.mgcvale.fluidfx.example.finance.model.Budget;
import dev.mgcvale.fluidfx.example.finance.model.Transaction;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class FinanceDashboardViewModel {
    private ObservableList<Transaction> transactions;
    private ObservableList<Budget> budgets;

    private StringProperty newTransactionDescription;
    private StringProperty newTransactionAmount;
    private StringProperty newTransactionCategory;
    private BooleanProperty newTransactionIsIncome;
    private StringProperty errorMessage;

    private DoubleProperty totalIncome;
    private DoubleProperty totalExpenses;
    private DoubleProperty netWorth;
    private StringProperty selectedPeriod;

    private ObjectProperty<Transaction> selectedTransaction;
    private ObjectProperty<Budget> selectedBudget;

    public FinanceDashboardViewModel() {
        initializeProperties();
        initializeData();
        setupBindings();
    }

    private void initializeProperties() {
        transactions = FXCollections.observableArrayList();
        budgets = FXCollections.observableArrayList();

        newTransactionDescription = new SimpleStringProperty("");
        newTransactionAmount = new SimpleStringProperty("");
        newTransactionCategory = new SimpleStringProperty("Food");
        newTransactionIsIncome = new SimpleBooleanProperty(false);
        errorMessage = new SimpleStringProperty("");

        totalIncome = new SimpleDoubleProperty(0.0);
        totalExpenses = new SimpleDoubleProperty(0.0);
        netWorth = new SimpleDoubleProperty(0.0);
        selectedPeriod = new SimpleStringProperty("This Month");

        selectedTransaction = new SimpleObjectProperty<>();
        selectedBudget = new SimpleObjectProperty<>();
    }

    private void initializeData() {
        transactions.addAll(
            new Transaction("Salary", 3500.0, "Income", LocalDate.now().minusDays(1), true),
            new Transaction("Groceries", -120.50, "Food", LocalDate.now().minusDays(2), false),
            new Transaction("Gas", -45.00, "Transportation", LocalDate.now().minusDays(3), false),
            new Transaction("Netflix", -12.99, "Entertainment", LocalDate.now().minusDays(4), false),
            new Transaction("Coffee", -4.50, "Food", LocalDate.now().minusDays(5), false),
            new Transaction("Freelance", 800.0, "Income", LocalDate.now().minusDays(6), true),
            new Transaction("Rent", -1200.0, "Housing", LocalDate.now().minusDays(7), false)
        );

        // Sample budgets
        budgets.addAll(
            new Budget("Food", 400.0, 125.0),
            new Budget("Transportation", 200.0, 45.0),
            new Budget("Entertainment", 150.0, 12.99),
            new Budget("Housing", 1200.0, 1200.0),
            new Budget("Shopping", 300.0, 0.0)
        );
    }

    private void setupBindings() {
        totalIncome.bind(Bindings.createDoubleBinding(() ->
                transactions.stream().filter(Transaction::isIncome).mapToDouble(Transaction::getAmount).sum(),
            transactions
        ));

        totalExpenses.bind(Bindings.createDoubleBinding(() ->
                Math.abs(transactions.stream().filter(t -> !t.isIncome()).mapToDouble(Transaction::getAmount).sum()),
            transactions
        ));

        netWorth.bind(totalIncome.subtract(totalExpenses));
    }

    public void addTransaction() {
        String description = newTransactionDescription.get().trim();
        String amountStr = newTransactionAmount.get().trim();

        if (description.isEmpty() || amountStr.isEmpty()) {
            errorMessage.set("Please fill in all fields");
            return;
        }

        try {
            double amount = Double.parseDouble(amountStr);
            if (!newTransactionIsIncome.get()) {
                amount = -Math.abs(amount);
            }

            Transaction transaction = new Transaction(
                description,
                amount,
                newTransactionCategory.get(),
                LocalDate.now(),
                newTransactionIsIncome.get()
            );

            transactions.add(0, transaction);

            if (!newTransactionIsIncome.get()) {
                updateBudgetSpending(newTransactionCategory.get(), Math.abs(amount));
            }

            clearForm();

        } catch (NumberFormatException e) {
            errorMessage.set("Please enter a valid amount");
        }
    }

    private void updateBudgetSpending(String category, double amount) {
        budgets.stream()
            .filter(b -> b.getCategory().equalsIgnoreCase(category))
            .findFirst()
            .ifPresent(budget -> budget.spentProperty().set(budget.getSpent() + amount));
    }

    public void deleteSelectedTransaction() {
        Transaction selected = selectedTransaction.get();
        if (selected != null) {
            transactions.remove(selected);
        }
    }

    private void clearForm() {
        newTransactionDescription.set("");
        newTransactionAmount.set("");
        newTransactionCategory.set("Food");
        newTransactionIsIncome.set(false);
        errorMessage.set("");
    }

    public ObservableList<Transaction> getTransactions() { return transactions; }
    public ObservableList<Budget> getBudgets() { return budgets; }

    public StringProperty newTransactionDescriptionProperty() { return newTransactionDescription; }
    public StringProperty newTransactionAmountProperty() { return newTransactionAmount; }
    public StringProperty newTransactionCategoryProperty() { return newTransactionCategory; }
    public BooleanProperty newTransactionIsIncomeProperty() { return newTransactionIsIncome; }
    public StringProperty errorMessageProperty() { return errorMessage; }

    public DoubleProperty totalIncomeProperty() { return totalIncome; }
    public DoubleProperty totalExpensesProperty() { return totalExpenses; }
    public DoubleProperty netWorthProperty() { return netWorth; }
    public StringProperty selectedPeriodProperty() { return selectedPeriod; }

    public ObjectProperty<Transaction> selectedTransactionProperty() { return selectedTransaction; }
    public ObjectProperty<Budget> selectedBudgetProperty() { return selectedBudget; }
}
