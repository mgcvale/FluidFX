package dev.mgcvale.fluidfx;

import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.groups.*;
import dev.mgcvale.fluidfx.components.layout.Pad;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        IntegerProperty counter = new SimpleIntegerProperty(0);

        stage.setScene(new Scene(
                new VGroup().wPadding(Pad.all(16)).wSpacing(12).wChildren(
                    new HGroup().spaceAround().wChildren(
                            new FLabel().inText(counter.asString("Count is %d")).hgrow()
                    ),
                    new HGroup().wSpacing(16).justifyCenter().wChildren(
                            new FButton("Increment").onAction(e -> counter.set(counter.get() + 1)),
                            new FButton("Decrement").onAction(e -> counter.set(counter.get() - 1)),
                            new FButton("Reset").onAction(e -> counter.set(0)).inDisable(counter.isEqualTo(0))
                    )
                )
        ));

        stage.show();
    }
}
