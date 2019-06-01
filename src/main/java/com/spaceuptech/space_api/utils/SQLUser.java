package com.spaceuptech.space_api.utils;

public class SQLUser {
    public String id;
    public String email;
    public  String name;
    public  String role;

    public SQLUser(String id, String email, String name, String role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "email: " + email + " id: "  + id + " name: " + name + " role: " + role;
    }
}
