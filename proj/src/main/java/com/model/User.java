package com.model;

import java.io.Serializable;

public class User implements Serializable {
    protected int id;
    protected String username;
    protected String password;
    protected String role;

    protected String email;

    public User(){

    }

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
