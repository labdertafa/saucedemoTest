package adapter;

import util.JsonLocator;

public interface ElementInteraction {
    void sendKeys(JsonLocator jsonLocator, String texto) throws Exception;
    void click(JsonLocator jsonLocator) throws Exception;
    String getText(JsonLocator jsonLocator) throws Exception;
    void selectByVisibleText(JsonLocator jsonLocator, String text) throws Exception;
    void selectByValue(JsonLocator jsonLocator, String value) throws Exception;
    void closeBrowser();
}