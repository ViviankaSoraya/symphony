package com.vi.symphony;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class Navigator {
    static Stage stage;
    static Stack<Scene> history = new Stack<>();

    public static void init(Stage primaryStage) {
        stage = primaryStage;
        stage.show();
    }

    public static void go(Parent screen) {
        history.push(stage.getScene());
        stage.setScene(new Scene(screen));
    }

    public static void replace(Parent screen) {
        stage.setScene(new Scene(screen));
    }

    public static void back() {
        stage.setScene(history.pop());
    }
}
