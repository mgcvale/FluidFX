# FluidFX Documentation

Welcome to FluidFX - the fluent, reactive UI framework for JavaFX.

## Quick Navigation

-  **[Getting Started](getting-started/)** - New to FluidFX? Start here
-  **[API Reference](api/)** - Complete API documentation
-  **[Guides](guides/)** - In-depth guides and best practices
-  **[Examples](examples/)** - Code examples and complete apps
-  **[Tutorials](tutorials/)** - Step-by-step learning paths

## Why FluidFX?

Traditionally, creating UIs in JavaFX (and Java in general) is verbose, messy and unstructured. You need to hold a reference to _every_ component you create, and each attribute has to be set in a new line.

FluidFX transforms this verbose JavaFX code into elegant, readable declarations:

```java

// Traditional JavaFX
VBox vbox = new VBox();
vbox.setSpacing(10);
vbox.setPadding(new Insets(10, 10, 10, 10));
Button btn = new Button("Click Me");
btn.setOnAction(e -> handleClick());
vbox.getChildren().add(btn);

// FluidFX
new VGroup()
    .wSpacing(10).wPadding(Pad.all(10))
    .wChildren(
        new FButton("Click Me").onAction(e -> handleClick()
    )
);
```

---
Besides making the process of creating UIs much more fun and fluid, this makes code more maintainable and readable. Instead of traversing through dozens of lines of code just to find a single component, you can find what you need by a quick glance at the FluidFX component tree, as it mimics the actual layout of your app, like HTML or FXML would.

Also, FluidFX comes equipped with handy reactive tools built around JavaFX's Observable API, making things like this possible:

```java

ObservableList<String> items = FXCollections.observableArrayList();

new VGroup().wSpacing(8).wChildren(
    new FButton("Add an item").onAction(e -> items.add("item")),
    new VGroup().inChildren(
        ListMapper.map(items, FLabel::new)
    )
);
```
<sub>here, the inChildren binds the items list _into_ the children property of the VGroup.</sub>

---
If you like this concept/idea, you can learn about how FluidFX works in [Getting Started](getting-started/)!
