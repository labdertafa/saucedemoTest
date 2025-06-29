package browserfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverManagerFactory {
    private static final Logger log = LogManager.getLogger(DriverManagerFactory.class);

    public static DriverManager getManager(DriverType type) {
        DriverManager manager = null;

        switch (type) {
            case CHROME -> {
                log.info("Se inicia la creación del WebDriver para CHROME");
                manager = new ChromeDriverManager();
            }
            case FIREFOX -> {
                log.info("Se inicia la creación del WebDriver para FIREFOX");
                manager = new FirefoxDriverManager();
            }
            case EDGE -> {
                log.info("Se inicia la creación del WebDriver para EDGE");
                manager = new EdgeDriverManager();
            }
            default -> log.error("El browser indicado no existe");
        }

        return manager;
    }
}