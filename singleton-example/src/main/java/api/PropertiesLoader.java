package api;

public interface PropertiesLoader {
    void uploadProperties(String pathToProperties);

    String getProperty(String key);
}
