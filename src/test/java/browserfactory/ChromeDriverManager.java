package browserfactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        // options.addArguments("--headless");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credential_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
    }
}