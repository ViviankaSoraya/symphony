package com.vi.symphony.screens;

import com.vi.symphony.Navigator;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BookingHistoryScreen extends VBox {
    public BookingHistoryScreen() {
        Text title = new Text("Booking History Screen");

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            Navigator.back();
        });

        this.getChildren().addAll(title, backButton);
    }
}
