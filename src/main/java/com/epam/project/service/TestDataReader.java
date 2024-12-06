package com.epam.project.service;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("testdata");

    public static String getTestData(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return System.getenv(key.toUpperCase().replace(".", "_"));
        }
    }
}