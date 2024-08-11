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

public class RegisterScreen extends VBox {
    public RegisterScreen() {
        Text title = new Text("Create Account");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");

        // Name
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        //Email
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        //Password
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button registerButton = new Button("Register");
        registerButton.setOnAction(actionEvent -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            Services.registerUser(name, email, password);
        });

        //Go Login
        Button goLoginButton = new Button("Go Login");
        goLoginButton.setOnMouseClicked(mouseEvent -> {
            Navigator.go(new LoginScreen());
        });

        HBox optionSection = new HBox(24, registerButton, goLoginButton);

        this.getChildren().addAll(title, nameField, emailField, passwordField, optionSection);
        this.setPadding(new Insets(100, 200, 100, 200));
        this.setSpacing(24);
    }
}

