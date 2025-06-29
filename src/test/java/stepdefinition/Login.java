package stepdefinition;

import adapter.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class Login extends TestBase {
    private final String acceptedUsernamesText = "Accepted usernames are:";
    private final String pageTittleText = "Swag Labs";
    private final String wrongCredentialsText = "Epic sadface: Username and password do not match any user in this service";
    private final String emptyUsernameText = "Epic sadface: Username is required";
    private final String emptyPasswordText = "Epic sadface: Password is required";

    public Login(TestContext testContext) throws IOException {
        super(testContext);
    }

    @Given("el usuario esta en la pagina de login")
    public void elUsuarioEstaEnLaPaginaDeLogin() throws Exception {
        String text = this.loginPage.getAcceptedUsernameText();
        assertEquals(acceptedUsernamesText, text);
    }

    @When("escribe el nombre de usuario {string}")
    public void escribeElNombreDeUsuario(String username) throws Exception {
        this.loginPage.sendUsername(username);
    }

    @When("escribe la clave {string}")
    public void escribeLaClave(String password) throws Exception {
        this.loginPage.sendPassword(password);
    }

    @When("pulsa el boton Login")
    public void pulsaElBotonLogin() throws Exception {
        this.loginPage.clickLoginButton();
    }

    @Then("el sistema muestra la pagina principal")
    public void elSistemaMuestraLaPaginaPrincipal() throws Exception {
        String tittle = this.mainPage.getPageTitle();
        assertEquals(pageTittleText, tittle);
    }

    @Then("el sistema muestra el error de credenciales incorrectas")
    public void elSistemaMuestraElErrorDeCredencialesIncorrectas() throws Exception {
        String message = this.loginPage.getErrorMessage();
        assertEquals(wrongCredentialsText, message);
    }

    @Then("el sistema muestra el error de usuario en blanco")
    public void elSistemaMuestraElErrorDeUsuarioEnBlanco() throws Exception {
        String message = this.loginPage.getErrorMessage();
        assertEquals(emptyUsernameText, message);
    }

    @Then("el sistema muestra el error de clave en blanco")
    public void elSistemaMuestraElErrorDeClaveEnBlanco() throws Exception {
        String message = this.loginPage.getErrorMessage();
        assertEquals(emptyPasswordText, message);
    }
}