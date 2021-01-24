import api.PropertiesLoader;
import api.impl.PropertiesLoaderSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PropertiesLoaderTest {
    private static final String PATH_TO_PROPERTIES = "some.properties";

    private final PropertiesLoader loader = PropertiesLoaderSingleton.getInstance(PATH_TO_PROPERTIES);

    @Test
    void correctUpload() {
        Assertions.assertEquals("Hello, World!", loader.getProperty("hello.world"));
    }

    @Test
    void singletonCheck() {
        Assertions.assertEquals(loader, PropertiesLoaderSingleton.getInstance(""));
    }
}
