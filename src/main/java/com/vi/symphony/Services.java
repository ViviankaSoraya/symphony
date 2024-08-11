package com.vi.symphony;

import com.vi.symphony.models.Booking;
import com.vi.symphony.models.Event;
import com.vi.symphony.models.User;
import com.vi.symphony.screens.BookingFinishScreen;
import com.vi.symphony.screens.HomeScreen;
import com.vi.symphony.screens.LoginScreen;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Services {

    public static void loginUser(String email, String password) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Integer userId = resultSet.getInt("id");
                String userEmail = resultSet.getString("email");
                String userName = resultSet.getString("name");

                User user = new User(userId, userEmail, userName);
                Session.getInstance().setUser(user);
                Navigator.go(new HomeScreen());
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Username or Password is incorrect");
            alert.showAndWait();
        }
    }

    public static void registerUser(String name, String email, String password) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.executeUpdate();
            Navigator.go(new LoginScreen());
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("User already registered!");
            alert.showAndWait();
        }
    }

    public static void addBooking(int userId, int eventId, int amount, String paymentMethod, int ticketCount) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO bookings (user_id, event_id, amount, payment_method, ticket_count) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, userId);
            statement.setInt(2, eventId);
            statement.setInt(3, amount);
            statement.setString(4,paymentMethod);
            statement.setInt(5,ticketCount);
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                int orderId = result.getInt(1);
                Navigator.replace(new BookingFinishScreen(orderId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Booking getBookingById(int bookingId) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM bookings WHERE id = ?");
            statement.setInt(1, bookingId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Booking booking = new Booking(
                        result.getInt("id"),
                        result.getInt("user_id"),
                        result.getInt("event_id"),
                        result.getTimestamp("booking_date"),
                        result.getInt("amount"),
                        result.getString("payment_method"),
                        result.getInt("ticket_count")
                );
                return booking;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Event> getEvents() {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM events");
            ResultSet resultSet = statement.executeQuery();

            ArrayList<Event> events = new ArrayList<> ();

            while (resultSet.next()) {
                Event event = new Event(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("poster"),
                        resultSet.getString("artist"),
                        resultSet.getTimestamp("date"),
                        resultSet.getString("location"),
                        resultSet.getInt("price")
                );
                events.add(event);
            }
            System.out.println(events.size());
            return events;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Event getEventDetail(int eventId) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM events WHERE id = ?");
            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Event event = new Event(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("poster"),
                        resultSet.getString("artist"),
                        resultSet.getTimestamp("date"),
                        resultSet.getString("location"),
                        resultSet.getInt("price")
                );
                return event;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
