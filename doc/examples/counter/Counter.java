
import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.groups.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Counter extends Application {

    @Override
    public void start(Stage stage) {
        IntegerProperty count = new SimpleIntegerProperty(0);

        Scene scene = new Scene(
            new VGroup().wStyleClass("p-2", "spacing-1", "align-tc").wChildren(
                new FLabel().inText(Bindings.createStringBinding(() -> "Count is " + count.get(), count)),

                new HGroup().justifyCenter().wStyleClass("spacing-2").wChildren(
                    new FButton("Increment").onAction(e -> count.set(count.get() + 1)),
                    new FButton("Decrement").onAction(e -> count.set(count.get() - 1)),
                    new FButton("Reset").onAction(e -> count.set(0))
                )
            )
        );

        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
