package stepdefinition;

import adapter.TestContext;
import pom.DetailPage;
import pom.LoginPage;
import pom.MainPage;

import java.io.IOException;

public class TestBase {
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected DetailPage detailPage;

    public TestBase(TestContext testContext) throws IOException {
        this.loginPage = new LoginPage("./config/loginpage.json", testContext.getElementInteraction());
        this.mainPage = new MainPage("./config/mainpage.json", testContext.getElementInteraction());
        this.detailPage = new DetailPage("./config/detailpage.json", testContext.getElementInteraction());
    }
}