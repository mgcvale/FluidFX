# Getting Started - Core Concepts

## Chapter 1: The Basics

Here, you will learn about the basics of FluidFX: Building component trees, basic properties and components. Most of 
what you will see here is pretty similar to default JavaFX, so this should be a walk in the park.

#### 1.1. Components

FluidFX's controls are named just like JavaFX controls, but with a F prefix (short for Fluid). So `Button` becomes
`FButton`, `Label` becomes `FLabel`, and so on.

Boxes/Layouts are similar, but they use a slightly different naming scheme. They borrow the prefix from the original
component (e.g. the H from HBox, or the Stack form StackPane), and then append a `Group` suffix to the end.
So `VBox` becomes `VGroup`, `BorderPane` becomes `BorderGroup`, and so on.

#### 1.2. Properties

In plain JavaFX, you use Getters and Setters to get/set properties of components. That's pretty straightforward - but it
doesn't quite work for FluidFX, as our framework follows a Chainable design pattern. For that reason, all of the setters
were overridden with chainable equivalents, prefixed with `w`. These equivalents just set that property, and return `this`.

For example:
In JavaFX, we could do:
```java
Label label = new Label();
label.setText("test");
label.setDisable(true);
```
but in FluidFX, we can do this instead:
```java
FLabel flabel = new FLabel().wText("test").wDisable(true);
```

Here, `w` stands for `with`, so `wText` means `withText`, and so on.

#### Applying what we've learned

With just these two ideas, we can already build pretty much any static UI in FluidFX.

Just use the exact same property names and classes JavaFX has, adapted to use FluidFX's prefixes/suffixes: 

```java
new VGroup().wSpacing(16).wPadding(Pad.all(24)).wChildren(

    new FLabel("Login").wStyleClass("text-6"), // We'll learn about these Tailwind-style CSS classes later.

    new VGroup().wSpacing(8).wChildren(
        new FLabel("Username"),
        new FTextField().wPrompt("Enter your username").wPrefWidth(200),

        new FLabel("Password"),
        new FTextField().wPrompt("Enter your password").wPrefWidth(200)
    ).vgrow(),

    new HGroup().wSpacing(12).wChildren(
        new FButton("Cancel").wDisable(true),

        new FButton("Login")
    ).wPadding(Pad.top(16))
);
```

This creates a simple login page. We will evolve it later with more features.

# 1.3. Spacers and Wrappers

Sometimes, we need some "filler" components in JavaFX, specially when using HBoxes and VBoxes.
For example, let's suppose you want a Header HBox where some elements are all the way to the left, and others are all 
the way to the right, kind of like this:
========================================================
| Element1 Element                 Element 3 Element 4 |
========================================================

To do this, we can create three HBoxes: one for the Header, one for elements 1 and 2, and a final one for element 3 and 4.
However, we need something with Priority.ALWAYS HGrow to make them spaced apart. FluidFX provides a handy util to do this:
Spacers.
To achieve such thing, we can do something just like this:

```java
new HGroup().wChildren(
    new HGroup().wChildren(new FLabel("Element1"), new FLabel("Element 2")),
    Spacers.hSpacer(Priority.ALWAYS), // We can also just use Spacers.hSpacer(), as Priority.ALWAYS is the default parameter.
    new HGroup().wChildren(new FLabel("Element 3"), new FLabel("Element4"))
);
```

This works well for loads of designs - but sometimes, it gets a bit verbose and messy.
Let's suppoose you need something like CSS's Flexbox's space-around feature, where elements are equally spaced.
In FluidFX, you could use HSpacers or VSpacers between every element - but that gets really verbose really quick. 
So we provide a built-in "justify" API in VBoxes and HBoxes, that auto-implement these common spacing layouts for you.

Here is an example:
```java
new HGroup().spaceAround().wChildren(
    new FLabel("Element 1"),
    new FLabel("Element 2"),
    new Flabel("Element 3"),
    new Flabel("Element 4")
)
```

.spaceAround() creates HSpacers between every element, but we also have other options. Here is a quick summary of what we can use:

1- .spaceAround() - spacers between every element
2- .spaceBetween() - spacers between every element, except for the start/end
3- .justifyCenter() - spacers in the start and end of the children, centering everything.
4- .justifyStart() - one spacer in the end of the children, to push everything to the start.
5- .justifyEnd() - one spacer in the start of the children, to push everything to the end.

In the topic of HBoxes and VBoxes, we should also talk about VGrow and HGrow. These are essential properties, which define
if a component should grow to occupy space inside a Box.
While FluidFX's approach to these properties does follow the patterns defined in `1.2. Properties`, I added an extra util: .vgrow() and .hgrow().
Because VGrow and HGrow are used almost all the time - and most commonly with Priority.ALWAYS, in FluidFX you can juts throw .vgrow() or .hgrow() into the
property chain of a Component, and that will add a grow with Priority.ALWAYS to it.

And finally, we also have the Wrapper class. It's pretty simple - it just applies a property onto a component, and returns itself.
It is useful to "fluidify" non-FluidFX components, for example:
```java
new HGroup().wChildren(
    wrapStyleClass(new Label("Test"), "text-red", "text-6")
);
```

#### 1.4. Style Classes

As you have probably seen, FluidFX comes with some handy Tailwind-style CSS classes. They are mainly designed to improve
UI consistency and make the code more concise.
Here is a small list of everything we currently have:

- text-\*: font size. From 01 (0.1em) all the way to 10 (10em).
- p-\*: padding. py, px, pb, pl, pt and pr are also available. Each number is equivalent to 1 pixel (e.g. p-1 is 4px of padding).
- border-radius-*: border radius. from sm (4px) to full (999px).
- background-radius-*: same as border radius, but for background radius.
- pref-w and pref-h: preferred width and height. from 1 (4px) to 256 (1024px).
- hand, crosshair, text, ...: for changing the cursor.
- spacing-\*: spacing for VBoxes and HBoxes. from 1 (4px) to 8 (32px).

Also, p-* classes can have the -i suffix, for applying the !important CSS tag.

#### Applying what we've learned

And... that's pretty much it for the basics! Let's apply what we've learned by improving that previous login screen.

```java
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
);
```
