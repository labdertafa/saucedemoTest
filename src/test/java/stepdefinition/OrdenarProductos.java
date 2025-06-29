package stepdefinition;

import adapter.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdenarProductos extends TestBase {
    private final String pageTittleText = "Swag Labs";

    public OrdenarProductos(TestContext testContext) throws IOException {
        super(testContext);
    }

    @Given("el usuario esta en la pagina principal con el usuario {string} y password {string}")
    public void el_usuario_esta_en_la_pagina_principal(String usuario, String password) throws Exception {
        this.loginPage.doLogin(usuario, password);
        String tittle = this.mainPage.getPageTitle();
        assertEquals(this.pageTittleText, tittle);
    }
    @When("selecciona la opcion {string}")
    public void selecciona_la_opcion(String opcion) throws Exception {
        this.mainPage.selectOrder(opcion);
    }
    @Then("el primer producto es {string}")
    public void el_primer_producto_es(String producto) throws Exception {
        String firstProductoName = this.mainPage.getFirstProduct();
        assertEquals(producto, firstProductoName);
    }
}