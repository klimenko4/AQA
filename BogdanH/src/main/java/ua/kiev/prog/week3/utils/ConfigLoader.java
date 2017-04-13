package ua.kiev.prog.week3.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import static java.util.Optional.ofNullable;

public class ConfigLoader {
    private static Properties properties;

    static {
        try {
            File file = ofNullable(ConfigLoader.class.getResource("/application.properties"))
                    .map(URL::getFile).
                            map(File::new)
                    .orElseThrow(IllegalArgumentException::new);

            properties = new Properties();
            properties.load(new FileInputStream(file));
            overrideWithSystemProperties();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void overrideWithSystemProperties() {
        Properties systemProperties = System.getProperties();

        for (Map.Entry entry : properties.entrySet()) {
            String key = String.valueOf(entry.getKey());
            if (systemProperties.containsKey(key)) {
                String value = systemProperties.getProperty(key);

                if (!value.isEmpty()) {
                    properties.setProperty(key, value);
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}