package com.vi.symphony.screens;

import com.vi.symphony.Navigator;
import com.vi.symphony.Services;
import com.vi.symphony.models.Event;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Objects;

public class EventDetailScreen extends VBox {
    int eventId;

    public EventDetailScreen(int id) {
        eventId = id;
        Event event = Services.getEventDetail(eventId);

        Text title = new Text("Event Detail");
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

        VBox eventDetail = new VBox(8, eventName, eventArtist, eventDate, eventLocation, eventPrice);
        HBox eventSection = new HBox(24, eventImage, eventDetail);

        Button bookingButton = new Button("Booking");
        bookingButton.setOnAction(eventClick -> {
            Navigator.go(new BookingEventScreen(eventId));
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(eventClick -> {
            Navigator.back();
        });

        HBox optionSection = new HBox(24, backButton, bookingButton);

        this.getChildren().addAll(title, eventSection, optionSection);
        this.setPadding(new Insets(50));
        this.setSpacing(24);
    }
}
