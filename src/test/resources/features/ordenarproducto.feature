Feature: Ordenar los productos en la página principal
  Como usuario quiero poder ordenar los productos por distintos criterios

  Background:
    Given el usuario esta en la pagina principal con el usuario "standard_user" y password "secret_sauce"

  Scenario Outline: el usuario establece el orden de los productos "<Orden>"
    When selecciona la opcion "<Opcion>"
    Then el primer producto es "<Producto>"

  Examples:
    | Orden                  | Opcion              | Producto                          |
    | Alfabético descendente | Name (Z to A)       | Test.allTheThings() T-Shirt (Red) |
    | Precio ascendente      | Price (low to high) | Sauce Labs Onesie                 |
    | Precio descendente     | Price (high to low) | Sauce Labs Fleece Jacket          |
