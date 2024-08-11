package com.vi.symphony.models;

import java.sql.Timestamp;

public class Event {
    public Integer id;
    public String name;
    public String poster;
    public String artist;
    public Timestamp date;
    public String location;
    public Integer price;

    public Event(Integer id, String name, String poster, String artist, Timestamp date, String location , Integer price) {
        this.id = id;
        this.name = name;
        this.poster = poster;
        this.artist = artist;
        this.date = date;
        this.location = location;
        this.price = price;
    }
};
