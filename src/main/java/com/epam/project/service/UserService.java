package com.epam.project.service;

import com.epam.project.model.User;

public class UserService {
    private static final String USER_PASSWORD_ENV = "USER_PASSWORD";

    public static User withCredentialsFromProperty() {
        String password = System.getenv(USER_PASSWORD_ENV);
        if (password == null) {
            throw new IllegalArgumentException("Environment variable 'USER_PASSWORD' not set.");
        }
        return new User(password);
    }
}