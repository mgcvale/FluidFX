package dev.mgcvale.fluidfx;

import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.groups.*;
import dev.mgcvale.fluidfx.reactive.BooleanMapper;
import dev.mgcvale.fluidfx.reactive.PropertyConverter;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        IntegerProperty counter = new SimpleIntegerProperty(0);

        scene = new Scene(
                new BorderGroup().withCenter(
                        new FluidButton("")
                                .bindTextProperty((StringBinding) Bindings.concat("Count is ", counter))
                                .onClick(e -> counter.set(counter.get() + 1))
                )
        );

        stage.setScene(scene);

        stage.show();
    }
}
