package com.myApp.core.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.myApp.core.driver.MyAndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class AppSettings {

    private static final String DEFAULT_CONFIG_FILE_NAME = "config_default.yml";
    private static final String LOCAL_CONFIG_FILE_NAME = "config.yml";
    private static final Logger LOGGER = Logger.getLogger(AppSettings.class.getName());
    public static AppSettings Instance = null;
    public static RemoteWebDriver androidDriver = null;

    static {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Instance = mapper.readValue(getConfigFile(), AppSettings.class);
            androidDriver = new MyAndroidDriver().getDriver();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    private static File getConfigFile() {
        File configFile = new File(LOCAL_CONFIG_FILE_NAME);
        if (!configFile.exists()) {
            LOGGER.info("local config file does not exist");
            configFile = new File(DEFAULT_CONFIG_FILE_NAME);
        }
        return configFile;
    }

    @JsonProperty
    public long NoSuchElementExceptionInterval;

}
