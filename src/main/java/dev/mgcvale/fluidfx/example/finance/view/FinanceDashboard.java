
package dev.mgcvale.fluidfx.example.finance.view;

import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.core.FluidGroup;
import dev.mgcvale.fluidfx.components.groups.*;
import dev.mgcvale.fluidfx.components.layout.Pad;
import dev.mgcvale.fluidfx.example.finance.model.Budget;
import dev.mgcvale.fluidfx.example.finance.model.Transaction;
import dev.mgcvale.fluidfx.example.finance.viewmodel.FinanceDashboardViewModel;
import dev.mgcvale.fluidfx.reactive.ListMapper;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FinanceDashboard extends BorderPane implements FluidGroup<FinanceDashboard> {

    public FinanceDashboard(FinanceDashboardViewModel vm) {
        setTop(createHeader(vm));

        setCenter(createMainContent(vm));

        setRight(createTransactionForm(vm));
    }

    private Pane createHeader(FinanceDashboardViewModel vm) {
        return new HGroup()
            .wPadding(Pad.all(20))
            .wSpacing(40)
            .wStyle("-fx-background-color: #2c3e50; -fx-text-fill: white;")
            .wChildren(
                new VGroup().wChildren(
                    new FLabel("Total Income").wStyle("-fx-text-fill: #95a5a6; -fx-font-size: 12px;"),
                    new FLabel().inText(vm.totalIncomeProperty().asString("$%.2f"))
                        .wStyle("-fx-text-fill: #27ae60; -fx-font-size: 24px; -fx-font-weight: bold;")
                ),
                new VGroup().wChildren(
                    new FLabel("Total Expenses").wStyle("-fx-text-fill: #95a5a6; -fx-font-size: 12px;"),
                    new FLabel().inText(vm.totalExpensesProperty().asString("$%.2f"))
                        .wStyle("-fx-text-fill: #e74c3c; -fx-font-size: 24px; -fx-font-weight: bold;")
                ),
                new VGroup().wChildren(
                    new FLabel("Net Worth").wStyle("-fx-text-fill: #95a5a6; -fx-font-size: 12px;"),
                    new FLabel().inText(vm.netWorthProperty().asString("$%.2f"))
                        .wStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;")
                )
            );
    }

    private Pane createMainContent(FinanceDashboardViewModel vm) {
        ObservableList<Node> budgetCards = ListMapper.map(vm.getBudgets(), this::createBudgetCard);

        budgetCards.addListener((ListChangeListener<Node>) System.out::println);

        return new HGroup().wSpacing(20).wPadding(Pad.all(20)).wChildren(
            new VGroup().hgrow().wChildren(
                new FLabel("Recent Transactions")
                    .wStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 0 0 10 0;"),
                new ScrollGroup().vgrow().wContent(
                    new FListView<Transaction>()
                        .wItems(vm.getTransactions())
                        .outSelectedItem(vm.selectedTransactionProperty())
                        .wCellFactory(lv -> new ListCell<Transaction>() {
                            @Override
                            protected void updateItem(Transaction transaction, boolean empty) {
                                super.updateItem(transaction, empty);
                                if (empty || transaction == null) {
                                    setGraphic(null);
                                } else {
                                    setGraphic(createTransactionCell(transaction));
                                }
                            }
                        })
                ),
                new HGroup().wSpacing(10).wPadding(Pad.top(10)).wChildren(
                    new FButton("Delete Selected")
                        .onAction(e -> vm.deleteSelectedTransaction())
                        .inDisable(vm.selectedTransactionProperty().isNull())
                        .wStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;")
                )
            ),

            // budget overview (right side)
            new VGroup().wPrefWidth(300).wChildren(
                new FLabel("Budget Overview")
                    .wStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 0 0 10 0;"),
                new VGroup().wSpacing(10).inChildren(
                    budgetCards
                )
            )
        );
    }

    private Pane createTransactionForm(FinanceDashboardViewModel vm) {
        return new VGroup()
            .wPrefWidth(280)
            .wPadding(Pad.all(20))
            .wSpacing(15)
            .wStyle("-fx-background-color: #ecf0f1;")
            .wChildren(
                new FLabel("Add Transaction")
                    .wStyle("-fx-font-size: 18px; -fx-font-weight: bold;"),

                new VGroup().wSpacing(8).wChildren(
                    new FLabel("Description"),
                    new FTextField()
                        .biText(vm.newTransactionDescriptionProperty())
                        .onKeyPressed(e -> vm.errorMessageProperty().set(""))
                ),

                new VGroup().wSpacing(8).wChildren(
                    new FLabel("Amount"),
                    new FTextField()
                        .biText(vm.newTransactionAmountProperty())
                        .onKeyPressed(e -> vm.errorMessageProperty().set(""))
                ),

                new VGroup().wSpacing(8).wChildren(
                    new FLabel("Category"),
                    new FTextField().biText(vm.newTransactionCategoryProperty())
                ),

                new FCheckBox("Is Income")
                    .biSelected(vm.newTransactionIsIncomeProperty()),

                new FLabel()
                    .biText(vm.errorMessageProperty())
                    .inVisible(vm.errorMessageProperty().isEmpty().not())
                    .wStyle("-fx-text-fill: #e74c3c; -fx-font-size: 12px;"),

                new FButton("Add Transaction")
                    .onAction(e -> vm.addTransaction())
                    .wStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;")
                    .wPrefWidth(Double.MAX_VALUE)
            );
    }

    private Pane createTransactionCell(Transaction transaction) {
        String amountStyle = transaction.isIncome() ?
            "-fx-text-fill: #27ae60; -fx-font-weight: bold;" :
            "-fx-text-fill: #e74c3c; -fx-font-weight: bold;";

        return new BorderGroup()
            .wPadding(Pad.all(10))
            .wLeft(new VGroup().wChildren(
                new FLabel().biText(transaction.descriptionProperty())
                    .wStyle("-fx-font-weight: bold;"),
                new FLabel().biText(transaction.categoryProperty())
                    .wStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 11px;")
            ))
            .wRight(new VGroup().wChildren(
                new FLabel(transaction.getFormattedAmount())
                    .wStyle(amountStyle),
                new FLabel().inText(transaction.dateProperty().asString())
                    .wStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 11px;")
            ));
    }

    private Pane createBudgetCard(Budget budget) {
        ProgressBar progressBar = new ProgressBar();
        progressBar.progressProperty().bind(
            budget.spentProperty().divide(budget.budgetedProperty())
        );
        progressBar.setPrefWidth(200);

        String progressColor = budget.getPercentageUsed() > 90 ? "#e74c3c" :
            budget.getPercentageUsed() > 75 ? "#f39c12" : "#27ae60";
        progressBar.setStyle("-fx-accent: " + progressColor + ";");

        return new VGroup()
            .wSpacing(8)
            .wPadding(Pad.all(15))
            .wStyle("-fx-background-color: white; -fx-background-radius: 8; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 2, 0, 0, 1);")
            .wChildren(
                new HGroup().wChildren(
                    new FLabel().inText(budget.categoryProperty()).hgrow()
                        .wStyle("-fx-font-weight: bold;"),
                    new FLabel().inText(budget.spentProperty().asString("$%.0f"))
                        .wStyle("-fx-text-fill: #7f8c8d;")
                ),
                progressBar,
                new HGroup().wChildren(
                    new FLabel().inText(budget.budgetedProperty().asString("Budget: $%.0f"))
                        .wStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 11px;"),
                    new FLabel().inText(
                        budget.budgetedProperty().subtract(budget.spentProperty()).asString("$%.0f left")
                    ).wStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 11px;")
                )
            );
    }

    @Override
    public Pane getSelf() {
        return this;
    }
}