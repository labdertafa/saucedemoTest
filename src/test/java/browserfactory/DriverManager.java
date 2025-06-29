package browserfactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver = null;

    protected abstract void createDriver();

    public void quitDriver() {
        if (this.driver != null) {
            this.driver.quit();
            this.driver = null;
        }
    }

    public WebDriver getDriver() {
        if (this.driver == null) {
            this.createDriver();
        }

        return this.driver;
    }
}