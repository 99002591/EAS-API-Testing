package com.eaton.easdr.api.framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private static final String FILE_PATH = "configs//config.properties";

    public ConfigFileReader() throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Configuration.properties not found at " + FILE_PATH, e);
        }
    }

    public String getApplicationUrl() {

        String url = properties.getProperty("url");

        if (url != null)
            return url;

        throw new RuntimeException("url is not specified in the Configuration.properties file.");
    }
}