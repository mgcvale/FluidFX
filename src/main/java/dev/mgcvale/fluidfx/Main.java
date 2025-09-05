package dev.mgcvale.fluidfx;

import dev.mgcvale.fluidfx.components.controls.*;
import dev.mgcvale.fluidfx.components.groups.*;
import dev.mgcvale.fluidfx.components.layout.Pad;
import dev.mgcvale.fluidfx.components.layout.Spacers;
import dev.mgcvale.fluidfx.components.util.Ref;
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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        IntegerProperty count = new SimpleIntegerProperty(0);
        BooleanProperty selected = new SimpleBooleanProperty(false);
        ObservableList<String> items = FXCollections.observableArrayList();
        DoubleProperty vgroupWidth = new SimpleDoubleProperty(0);

        Ref<VGroup> vGroupRef = new Ref<>(null);

        Scene scene = new Scene(
            new VGroup().wPrefWidth(256).grabInstance(vGroupRef).wAlignment(Pos.TOP_CENTER).wChildren(
                new FTextField().inMaxWidth(vGroupRef.ref.widthProperty().multiply(0.8)).hgrow()
            )
        );

        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);

        stage.show();
    }
}
