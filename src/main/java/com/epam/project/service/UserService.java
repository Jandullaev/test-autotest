package com.epam.project.service;

import com.epam.project.model.User;

public class UserService {
    private static final String USER_EMAIL = "user.email";
    private static final String USER_PASSWORD = "USER_PASSWORD";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(USER_EMAIL), System.getenv(USER_PASSWORD));
    }
}