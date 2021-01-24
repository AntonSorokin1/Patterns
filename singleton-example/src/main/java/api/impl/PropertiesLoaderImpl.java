package api.impl;

import api.PropertiesLoader;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoaderImpl implements PropertiesLoader {
    private static final Logger LOGGER = Logger.getLogger(PropertiesLoaderImpl.class);

    private final Properties properties = new Properties();

    @Override
    public void uploadProperties(String pathToProperties) {
        try (InputStream inputStream = PropertiesLoaderSingleton.class.getClassLoader().getResourceAsStream(pathToProperties)) {
            properties.load(inputStream);
        }
        catch (IOException exception) {
            LOGGER.error("Can not read properties!\n" + exception.toString());
        }
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
