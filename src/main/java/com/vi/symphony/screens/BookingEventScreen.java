package com.vi.symphony.screens;

import com.vi.symphony.Navigator;
import com.vi.symphony.Services;
import com.vi.symphony.Session;
import com.vi.symphony.models.Event;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Objects;

public class BookingEventScreen extends VBox {
    int eventId;

    public BookingEventScreen(int id) {
        eventId = id;
        Event event = Services.getEventDetail(eventId);

        Text title = new Text("Booking Event");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");

        ImageView eventImage = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/events/"+ event.poster))));
        eventImage.setFitWidth(120);
        eventImage.setPreserveRatio(true);

        Text eventName = new Text(event.name);
        eventName.setStyle("-fx-font-weight: bold; -fx-font-size: 16px");
        Text eventArtist = new Text("Artist: " + event.artist);
        Text eventDate = new Text("Date: " + event.date);
        Text eventLocation = new Text("Location: " + event.location);
        Text eventPrice = new Text("Price: $" + event.price);

        VBox eventDetail = new VBox(eventName, eventArtist, eventDate, eventLocation, eventPrice);
        HBox eventSection = new HBox(24, eventImage, eventDetail);

        Text ticketLabel = new Text("Booking");
        TextField ticketCountField = new TextField();
        ticketCountField.setPromptText("Ticket count");
        VBox bookingSection = new VBox(8, ticketLabel, ticketCountField );

        ArrayList<String> payments = new ArrayList<>();
        payments.add("Dana");
        payments.add("BCA");
        payments.add("BRI");

        Text paymentLabel = new Text("Payment");
        ComboBox<String> paymentList = new ComboBox<>();
        paymentList.getItems().addAll(payments);
        paymentList.setValue(payments.getFirst());
        VBox paymentSection = new VBox(paymentLabel, paymentList);

        Button buyButton = new Button("Buy Ticket");
        buyButton.setOnAction(eventClick -> {
            int userId = Session.getInstance().getUser().id;
            int amount = Integer.parseInt(ticketCountField.getText()) * event.price;
            String paymentMethod = paymentList.getValue();
            int ticketCount = Integer.parseInt(ticketCountField.getText());
            Services.addBooking(userId, eventId, amount, paymentMethod, ticketCount);
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(eventClick -> {
            Navigator.back();
        });

        HBox optionSection = new HBox(24, backButton, buyButton);

        this.getChildren().addAll(title, eventSection, bookingSection, paymentSection, optionSection);
        this.setPadding(new Insets(50));
        this.setSpacing(24);
    }
}
