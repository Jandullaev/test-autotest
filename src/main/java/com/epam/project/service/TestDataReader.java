package com.epam.project.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle("testdata");
    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
