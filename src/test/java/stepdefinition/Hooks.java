package stepdefinition;

import adapter.TestContext;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    private static final Logger log = LogManager.getLogger(Hooks.class);

    private final TestContext testContext;
    private static int paso;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp(Scenario scenario) {
        log.info("Inicialización del WebDriver para el escenario: {}", scenario.getName());
        paso = 0;
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Se libera el WebDriver para el escenario: {}", scenario.getName());
        this.testContext.getElementInteraction().closeBrowser();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        paso++;
        log.info("Se va a ejecutar el paso {} del escenario: {}", paso, scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        log.info("Se ha ejecutado el paso {} del escenario: {}", paso, scenario.getName());
    }
}