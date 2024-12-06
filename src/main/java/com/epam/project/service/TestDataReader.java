package com.epam.project.service;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle;

    static {
        ResourceBundle tempBundle;
        try {
            tempBundle = ResourceBundle.getBundle("testdata");
        } catch (MissingResourceException e) {
            tempBundle = null; // Handle the case where the properties file is missing
        }
        resourceBundle = tempBundle;
    }

    public static String getTestData(String key) {
        // Convert key to uppercase and replace dots with underscores for environment variable access
        String envKey = key.toUpperCase().replace(".", "_");
        String value = System.getenv(envKey);
        if (value != null) {
            return value;
        }

        // If the properties file is not available, return null or throw an exception
        if (resourceBundle != null) {
            try {
                return resourceBundle.getString(key);
            } catch (MissingResourceException e) {
                // Handle missing key in properties file
            }
        }

        throw new IllegalStateException("Neither environment variable nor properties file contains the key: " + key);
    }
}