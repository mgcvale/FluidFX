module fluidfx {
    requires javafx.controls;
    requires javafx.base;
    requires java.compiler;
    requires java.desktop;

    exports dev.mgcvale.fluidfx.reactive;
    exports dev.mgcvale.fluidfx.components.controls;
    exports dev.mgcvale.fluidfx.components.core;
    exports dev.mgcvale.fluidfx.components.util;
    exports dev.mgcvale.fluidfx.components.groups;
    exports dev.mgcvale.fluidfx.example.todolist;
    exports dev.mgcvale.fluidfx.example.todolist.model;
    exports dev.mgcvale.fluidfx.example.todolist.view;
    exports dev.mgcvale.fluidfx.example.todolist.viewmodel;
    exports dev.mgcvale.fluidfx.components.layout;
    exports dev.mgcvale.fluidfx.example.finance.viewmodel;
    exports dev.mgcvale.fluidfx.example.finance.model;
    exports dev.mgcvale.fluidfx.example.finance.view;
    exports dev.mgcvale.fluidfx.example.finance;
    exports dev.mgcvale.fluidfx;

}
