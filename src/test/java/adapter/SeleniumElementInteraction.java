package adapter;

import browserfactory.DriverManager;
import browserfactory.DriverManagerFactory;
import browserfactory.DriverType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.JsonLocator;

import java.time.Duration;

public class SeleniumElementInteraction implements ElementInteraction {
    private static final Logger log = LogManager.getLogger(SeleniumElementInteraction.class);

    private final DriverManager driverManager;
    private final WebDriver driver;

    public SeleniumElementInteraction(DriverType driverType, String pagina) {
        this.driverManager = DriverManagerFactory.getManager(driverType);
        this.driver = this.driverManager.getDriver();
        this.driver.manage().window().maximize();
        this.driver.get(pagina);
    }

    private By getLocator(JsonLocator jsonLocator) {
        switch (jsonLocator.getGetFieldBy()) {
            case "id" -> {
                return By.id(jsonLocator.getValueToFind());
            }
            case "name" -> {
                return By.name(jsonLocator.getValueToFind());
            }
            case "className" -> {
                return By.className(jsonLocator.getValueToFind());
            }
            case "tagName" -> {
                return By.tagName(jsonLocator.getValueToFind());
            }
            case "linkText" -> {
                return By.linkText(jsonLocator.getValueToFind());
            }
            case "partialLinkText" -> {
                return By.partialLinkText(jsonLocator.getValueToFind());
            }
            case "cssSelector" -> {
                return By.cssSelector(jsonLocator.getValueToFind());
            }
            case "xpath" -> {
                return By.xpath(jsonLocator.getValueToFind());
            }
            default -> {
                throw new RuntimeException("Método de localizador desconocido: " + jsonLocator.getValueToFind());
            }
        }
    }

    private WebElement findElement(JsonLocator jsonLocator) throws Exception {
        try {
            By locator = this.getLocator(jsonLocator);

            WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(20));
            ewait.until(ExpectedConditions.presenceOfElementLocated(locator));

            return this.driver.findElement(locator);
        } catch (Exception e) {
            log.error("Error buscando el elemento: {}", jsonLocator.toString());
            log.error("Detalle: {}", e.getMessage());
            throw new Exception(String.format("No se encontró el elemento: %s", jsonLocator.toString()));
        }
    }

    @Override
    public void sendKeys(JsonLocator jsonLocator, String texto) throws Exception {
        WebElement webElement = this.findElement(jsonLocator);
        webElement.sendKeys(texto);
    }

    @Override
    public void click(JsonLocator jsonLocator) throws Exception {
        WebElement webElement = this.findElement(jsonLocator);
        webElement.click();
    }

    @Override
    public String getText(JsonLocator jsonLocator) throws Exception {
        WebElement webElement = this.findElement(jsonLocator);
        return webElement.getText();
    }

    @Override
    public void closeBrowser() {
        this.driverManager.quitDriver();
    }
}