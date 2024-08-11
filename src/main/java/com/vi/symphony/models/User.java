package com.vi.symphony.models;

public class User {
    public Integer id;
    public String email;
    public String name;

    public User(Integer id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
