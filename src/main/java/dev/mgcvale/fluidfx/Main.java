package dev.mgcvale.fluidfx;

import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.groups.*;
import dev.mgcvale.fluidfx.components.layout.Pad;
import dev.mgcvale.fluidfx.components.layout.Spacers;
import dev.mgcvale.fluidfx.reactive.ListMapper;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        ObservableList<String> items = FXCollections.observableArrayList();

        Scene scene = new Scene(

            new VGroup().wStyleClass("p-6", "spacing-3").wChildren(

                new FLabel("Login").wStyleClass("text-6").wTextAlignment(TextAlignment.CENTER),

                new VGroup().wSpacing(8).wChildren(
                    new FLabel("Username"),
                    new FTextField().wPrompt("Enter your username").wPrefWidth(200),

                    Spacers.vSpacer(24), // we can also use fixed sizes of bindings on spacers

                    new FLabel("Password"),
                    new FTextField().wPrompt("Enter your password").wPrefWidth(200)
                ).vgrow(),

                new HGroup().justifyCenter().wStyleClass("spacing-3", "pb-4").wChildren(
                    new FButton("Cancel").wDisable(true),

                    new FButton("Login")
                ).wPadding(Pad.top(16))
            )
        );

        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);

        stage.show();
    }
}
