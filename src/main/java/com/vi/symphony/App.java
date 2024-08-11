package com.vi.symphony;

import com.vi.symphony.screens.LoginScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setWidth(800);
        stage.setHeight(600);

        Navigator.init(stage);
        Navigator.go(new LoginScreen());
    }

    public static void main(String[] args) {
        launch();
    }
}