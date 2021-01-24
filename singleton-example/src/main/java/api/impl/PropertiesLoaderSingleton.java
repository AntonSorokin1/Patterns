package api.impl;

import api.PropertiesLoader;

public class PropertiesLoaderSingleton extends PropertiesLoaderImpl {
    private static PropertiesLoader instance;

    private PropertiesLoaderSingleton(String pathToProperties) {
        uploadProperties(pathToProperties);
    }

    public static synchronized PropertiesLoader getInstance(String pathToProperties) {
        if (instance == null) {
            instance = new PropertiesLoaderSingleton(pathToProperties);
        }
        return instance;
    }
}
