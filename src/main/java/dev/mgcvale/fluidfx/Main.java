package dev.mgcvale.fluidfx;

import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.groups.*;
import dev.mgcvale.fluidfx.components.layout.Pad;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        IntegerProperty counter = new SimpleIntegerProperty(0);

        stage.setScene(new Scene(
                new VGroup().withPadding(Pad.all(16)).withSpacing(12).withChildren(
                    new HGroup().spaceAround().withChildren(
                            new FluidLabel().bindTextProperty(counter.asString("Count is %d")).hGrow()
                    ),
                    new HGroup().withSpacing(16).justifyCenter().withChildren(
                            new FluidButton("Increment").withOnAction(e -> counter.set(counter.get() + 1)),
                            new FluidButton("Decrement").withOnAction(e -> counter.set(counter.get() - 1)),
                            new FluidButton("Reset").withOnAction(e -> counter.set(0)).bindDisable(counter.isEqualTo(0))
                    )
                )
        ));

        stage.show();
    }
}
