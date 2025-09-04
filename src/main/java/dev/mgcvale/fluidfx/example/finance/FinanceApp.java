
package dev.mgcvale.fluidfx.example.finance;

import dev.mgcvale.fluidfx.example.finance.view.FinanceDashboard;
import dev.mgcvale.fluidfx.example.finance.viewmodel.FinanceDashboardViewModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinanceApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        FinanceDashboardViewModel viewModel = new FinanceDashboardViewModel();
        FinanceDashboard dashboard = new FinanceDashboard(viewModel);

        Scene scene = new Scene(dashboard, 1200, 800);
        primaryStage.setTitle("Personal Finance Dashboard - FluidFX Showcase");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}