package com.epam.project.service;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle("testdata");

    public static String getTestData(String key) {
        // Convert key to uppercase and replace dots with underscores for environment variable access
        String envKey = key.toUpperCase().replace(".", "_");
        String value = System.getenv(envKey);
        if (value != null) {
            return value;
        }
        return resourceBundle.getString(key);
    }
}