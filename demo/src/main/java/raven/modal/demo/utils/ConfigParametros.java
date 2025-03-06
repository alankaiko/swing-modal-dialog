package raven.modal.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigParametros {
    private Properties properties;

    public ConfigParametros(String configFilePath) {
        this.properties = new Properties();
        try (FileInputStream input = new FileInputStream(configFilePath)) {
            this.properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }
}
