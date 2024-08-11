package com.vi.symphony.screens;

import com.vi.symphony.Navigator;
import com.vi.symphony.Services;
import com.vi.symphony.models.Event;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Objects;

public class HomeScreen extends VBox {
    public HomeScreen() {
        ArrayList<Event> events = Services.getEvents();

        Text title = new Text("Home Screen");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");

        HBox popularEvents = new HBox(24);

        events.forEach(event -> {
            ImageView eventImage = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/events/" + event.poster))));
            eventImage.setFitWidth(120);
            eventImage.setPreserveRatio(true);
            Text eventName = new Text(event.name);
            eventName.setStyle("-fx-font-weight: bold; -fx-font-size: 16px");
            Text eventArtist = new Text(event.artist);
            VBox eventCard = new VBox(eventImage, eventName, eventArtist);
            eventCard.setOnMouseClicked(mouseEvent -> {
                Navigator.go(new EventDetailScreen(event.id));
            });
            popularEvents.getChildren().add(eventCard);
        });

        this.getChildren().addAll(title, popularEvents);
        this.setPadding(new Insets(48));
        this.setSpacing(24);
    }
}