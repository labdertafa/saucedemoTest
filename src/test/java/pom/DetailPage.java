package pom;

import adapter.ElementInteraction;
import util.JsonLocator;
import util.JsonLocatorManager;

import java.io.IOException;
import java.util.Map;

public class DetailPage {
    private final ElementInteraction elementInteraction;
    private final Map<String, JsonLocator> detailPageLocators;

    private final String productNameKey = "productName";

    public DetailPage(String pageDefinitionFilePath, ElementInteraction elementInteraction) throws IOException {
        this.elementInteraction = elementInteraction;
        this.detailPageLocators = JsonLocatorManager.getLocators(pageDefinitionFilePath);
    }

    public String getProductName() throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.detailPageLocators, this.productNameKey);
        return elementInteraction.getText(jsonLocator);
    }
}