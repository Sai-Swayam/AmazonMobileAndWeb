package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        properties = new Properties();

        try {
            InputStream configInputStream = ConfigReader.class.getClassLoader()
                    .getResourceAsStream("config.properties");

            properties.load(configInputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // TODO system.getProperty implementation for commandline
    public static String getProperty(String property) {
        return properties.getProperty(property);
    }
}
