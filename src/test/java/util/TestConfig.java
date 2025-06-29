package util;

import adapter.AdapterType;
import browserfactory.DriverType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    private static final Logger log = LogManager.getLogger(TestConfig.class);

    private TestConfig() {
    }

    public static String readProperty(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("./config/config.properties"));
        return properties.getProperty(key);
    }

    public static DriverType getDriverType() {
        String navegador;

        try {
            navegador = TestConfig.readProperty("navegador");
            if (navegador == null) {
                log.error("Hay un problema con la configuración. Usando la configuración por defecto.");
                navegador = "Chrome";
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error recuperando la configuración. Usando la configuración por defecto.");
            navegador = "Chrome";
        }

        log.info("Se ha recuperado la configuración del navegador: {}", navegador);
        return DriverType.valueOf(navegador.toUpperCase());
    }

    public static String getPageToTest() {
        String pagina;

        try {
            pagina = readProperty("urlbase");
            if (pagina == null) {
                pagina = "https://www.saucedemo.com/";
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error recuperando la configuración de la página. Usando la configuración por defecto");
            pagina = "https://www.saucedemo.com/";
        }

        log.info("Se ha recuperado la configuración de la pagína: {}", pagina);
        return pagina;
    }

    public static AdapterType getAdapterType() {
        String adaptador;
        try {
            adaptador = readProperty("adapter");
            if (adaptador == null) {
                log.error("Hay un problema con la configuración de la librería de pruebas. Usando la configuración por defecto");
                adaptador = "Selenium";
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error recuperando el la librería de pruebas a usar. Usando la configuración por defecto");
            adaptador = "Selenium";
        }

        log.info("Se ha recuperado la librería de pruebas a usar: {}", adaptador);
        return AdapterType.valueOf(adaptador.toUpperCase());
    }
}