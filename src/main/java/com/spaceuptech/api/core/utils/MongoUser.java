package com.spaceuptech.api.core.utils;

public class MongoUser {
    public String _id;
    public String email;
    public  String name;
    public  String role;

    public MongoUser(String _id, String email, String name, String role) {
        this._id = _id;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "email: " + email + " id: "  + _id + " name: " + name + " role: " + role;
    }
}
