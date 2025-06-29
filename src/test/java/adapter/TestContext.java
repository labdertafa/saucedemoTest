package adapter;

import browserfactory.DriverType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.TestConfig;

public class TestContext {
    private static final Logger log = LogManager.getLogger(TestContext.class);

    private final ElementInteraction elementInteraction;

    public TestContext() throws Exception {
        log.info("Iniciando el contexto del test");

        // Se obtiene el navagador a usar
        DriverType driverType = TestConfig.getDriverType();

        // Se obtiene la página a probar
        String pagina = TestConfig.getPageToTest();

        // Se obtiene el tipo de adaptador a usar;
        AdapterType adapterType = TestConfig.getAdapterType();
        switch (adapterType) {
            case SELENIUM -> {
                this.elementInteraction = new SeleniumElementInteraction(driverType, pagina);
                log.info("Se ha inicializado el adaptador Selenium");
            }
            default -> {
                log.error("Grave: no está definida la librería a usar en las pruebas");
                throw new RuntimeException("No está definida la librería a usar en las pruebas");
            }
        }

        log.info("Ha terminado la inicialización del contexto del test");
    }

    public ElementInteraction getElementInteraction() {
        return elementInteraction;
    }
}