package pom;

import adapter.ElementInteraction;
import util.JsonLocator;
import util.JsonLocatorManager;

import java.io.IOException;
import java.util.Map;

public class LoginPage {
    private final ElementInteraction elementInteraction;
    private final Map<String, JsonLocator> loginpageLocators;

    private final String acceptedUsernameKey = "acceptedUsername";
    private final String usernameFieldKey = "usernameField";
    private final String passwordFieldKey = "passwordField";
    private final String loginButtonKey = "loginButton";
    private final String errorMessageKey = "errorMessage";

    public LoginPage(String pageDefinitionFilePath, ElementInteraction elementInteraction) throws IOException {
        this.loginpageLocators = JsonLocatorManager.getLocators(pageDefinitionFilePath);
        this.elementInteraction = elementInteraction;
    }

    public String getAcceptedUsernameText() throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.loginpageLocators, this.acceptedUsernameKey);
        return this.elementInteraction.getText(jsonLocator);
    }

    public void sendUsername(String username) throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.loginpageLocators, this.usernameFieldKey);
        this.elementInteraction.sendKeys(jsonLocator, username);
    }

    public void sendPassword(String password) throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.loginpageLocators, this.passwordFieldKey);
        this.elementInteraction.sendKeys(jsonLocator, password);
    }

    public void clickLoginButton() throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.loginpageLocators, this.loginButtonKey);
        this.elementInteraction.click(jsonLocator);
    }

    public String getErrorMessage() throws Exception {
        JsonLocator jsonLocator = JsonLocatorManager.getLocator(this.loginpageLocators, this.errorMessageKey);
        return this.elementInteraction.getText(jsonLocator);
    }

    public void doLogin(String username, String password) throws Exception {
        this.sendUsername(username);
        this.sendPassword(password);
        this.clickLoginButton();
    }
}
