package com.vi.symphony;

import com.vi.symphony.models.User;

public class Session {
    private static Session instance;
    private User user;

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void ClearSession() {
        this.user = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
