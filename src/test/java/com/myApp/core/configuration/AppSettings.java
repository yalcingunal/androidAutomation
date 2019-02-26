package com.myApp.core.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class AppSettings {

    private static final String DEFAULT_CONFIG_FILE_NAME = "config_default.yml";
    private static final String LOCAL_CONFIG_FILE_NAME = "config.yml";
    private static final Logger LOGGER = Logger.getLogger(AppSettings.class.getName());
    public static AppSettings Instance = null;

    static {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Instance = mapper.readValue(getConfigFile(), AppSettings.class);
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
    public String AppPath;

    @JsonProperty
    public String DeviceName;

    @JsonProperty
    public String AppiumServerUrl;

}
