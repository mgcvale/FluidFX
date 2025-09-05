package dev.mgcvale.fluidfx;

import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.groups.*;
import dev.mgcvale.fluidfx.components.layout.Pad;
import dev.mgcvale.fluidfx.components.layout.Spacers;
import dev.mgcvale.fluidfx.reactive.BooleanMapper;
import dev.mgcvale.fluidfx.reactive.ListMapper;
import dev.mgcvale.fluidfx.reactive.PropertyConverter;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        IntegerProperty count = new SimpleIntegerProperty(0);
        BooleanProperty selected = new SimpleBooleanProperty(false);
        ObservableList<String> items = FXCollections.observableArrayList();

        Scene scene = new Scene(
            new VGroup().wChildren(
                FSpinner.intSpinner(0, 10, 0).biValue(count.asObject()),
                new FLabel().inText(Bindings.createStringBinding(() -> {
                        if (count.get() > 5) return "Count is " + count.get() + ". That's a lot!";
                        return "Count is " + count.get() + ".";
                    }, count)
                )
            )
        );

        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);

        stage.show();
    }
}
