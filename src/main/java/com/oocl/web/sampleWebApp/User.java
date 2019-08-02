package com.oocl.web.sampleWebApp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = "id", allowGetters = true)
public class User {
    private String username;
    private int id;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public int hashCode() {
        return (username + id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return username.equals(((User) obj).getUsername())
                && id == ((User) obj).getId();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
