package dev.mgcvale.fluidfx;

import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.groups.*;
import dev.mgcvale.fluidfx.components.layout.Pad;
import dev.mgcvale.fluidfx.reactive.ListMapper;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        ObservableList<String> items = FXCollections.observableArrayList();

        stage.setScene(new Scene(
            new VGroup().wSpacing(8).wChildren(
                new FButton("Add an item").onAction(e -> items.add("item")),
                new VGroup().inChildren(
                    ListMapper.map(items, FLabel::new)
                )
            )
        ));

        stage.show();
    }
}
