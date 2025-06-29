package util;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonLocatorManager {
    private JsonLocatorManager() {
    }

    public static Map<String, JsonLocator> getLocators(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
                new File(filePath),
                new TypeReference<Map<String, JsonLocator>>() {}
        );
    }

    public static JsonLocator getLocator(Map<String, JsonLocator> locators, String locatorKey) {
        JsonLocator jsonLocator = locators.get(locatorKey);
        if (locators == null) {
            throw new RuntimeException("No se encontró el localizador: " + locatorKey);
        }

        return jsonLocator;
    }
}