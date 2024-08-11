package com.vi.symphony.screens;

import com.vi.symphony.Navigator;
import com.vi.symphony.Services;
import com.vi.symphony.models.Booking;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BookingFinishScreen extends VBox {
    int bookingId;

    public BookingFinishScreen(int id) {
        bookingId = id;
        Booking booking = Services.getBookingById(bookingId);

        Text title = new Text("Booking Finish");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");

        Text bookingAmount = new Text("Rp" + booking.amount);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            Navigator.back();
        });

        this.getChildren().addAll(title, bookingAmount, backButton);
        this.setPadding(new Insets(50));
        this.setSpacing(24);
    }
}
