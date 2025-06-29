package stepdefinition;

import adapter.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerDetalle extends TestBase {
    private final String pageTittleText = "Swag Labs";

    public VerDetalle(TestContext testContext) throws IOException {
        super(testContext);
    }

    @Given("el usuario {string} con password {string} esta en la pagina principal\"")
    public void el_usuario_con_password_esta_en_la_pagina_principal(String username, String password) throws Exception {
        this.loginPage.doLogin(username, password);
        String tittle = this.mainPage.getPageTitle();
        assertEquals(pageTittleText, tittle);
    }
    @When("hace click sobre producto {string}")
    public void hace_click_sobre_producto(String localizador) throws Exception {
        this.mainPage.clickProduct(localizador);
    }
    @Then("el sistema muestra el detalle del producto {string}")
    public void el_sistema_muestra_el_detalle_del_producto(String nombreProducto) throws Exception {
        String productName = this.detailPage.getProductName();
        assertEquals(nombreProducto, productName);
    }
}