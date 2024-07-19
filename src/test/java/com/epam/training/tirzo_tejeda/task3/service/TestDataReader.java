package com.epam.training.tirzo_tejeda.task3.service;

import java.util.ResourceBundle;

/**
 * Utility class to read test data from a ResourceBundle based on the environment.
 */
public class TestDataReader {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    /**
     * Retrieves test data value associated with the specified key.
     * @param key The key to look up in the test data ResourceBundle.
     * @return The test data value associated with the key.
     */
    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
