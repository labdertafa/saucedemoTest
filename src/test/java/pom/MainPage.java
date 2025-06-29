package pom;

import adapter.ElementInteraction;
import util.JsonLocator;
import util.JsonLocatorManager;

import java.io.IOException;
import java.util.Map;

public class MainPage {
    private final ElementInteraction elementInteraction;
    private final Map<String, JsonLocator> mainpageLocators;

    private final String pageTittleKey = "pageTittle";
    private final String selectOrderKey = "orderComboBox";
    private final String firstProductKey = "firstProductInList";

    public MainPage(String pageDefinitionFilePath, ElementInteraction elementInteraction) throws IOException {
        this.elementInteraction = elementInteraction;
        this.mainpageLocators = JsonLocatorManager.getLocators(pageDefinitionFilePath);
    }

    public String getPageTitle() throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.mainpageLocators, this.pageTittleKey);
        return this.elementInteraction.getText(jsonLocator);
    }

    public void clickProduct(String nombreLocalizador) throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.mainpageLocators, nombreLocalizador);
        this.elementInteraction.click(jsonLocator);
    }

    public void selectOrder(String choisedOrder) throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.mainpageLocators, this.selectOrderKey);
        this.elementInteraction.selectByVisibleText(jsonLocator, choisedOrder);
    }

    public String getFirstProduct() throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.mainpageLocators, this.firstProductKey);
        return this.elementInteraction.getText(jsonLocator);
    }
}
