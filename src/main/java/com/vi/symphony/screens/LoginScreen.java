package com.vi.symphony.screens;

import com.vi.symphony.Navigator;
import com.vi.symphony.Services;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LoginScreen extends VBox {
    public LoginScreen() {
        Text title = new Text("Welcome!");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(actionEvent -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            Services.loginUser(email, password);
        });

        // Go Register
        Button goRegisterButton = new Button("Go Register");
        goRegisterButton.setOnMouseClicked(mouseEvent -> {
            Navigator.go(new RegisterScreen());
        });

        HBox optionSection = new HBox(24, loginButton, goRegisterButton);

        this.getChildren().addAll(title, emailField, passwordField, optionSection);
        this.setPadding(new Insets(100, 200, 100, 200));
        this.setSpacing(24);
    }
}
