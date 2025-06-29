Feature: ver el detalle de un producto
  Como usuario, quiero poder consultar el detalle de un producto

  Scenario Outline: consultar el detalle de un producto
    Given el usuario "<usuario>" con password "<password>" esta en la pagina principal"
    When hace click sobre producto "<producto>"
    Then el sistema muestra el detalle del producto "<nombre>"

    Examples:
    | usuario       | password     | producto           | nombre                |
    | standard_user | secret_sauce | sauceLabsBackpack  | Sauce Labs Backpack   |
    | standard_user | secret_sauce | sauceLabsOnesie    | Sauce Labs Onesie     |
    | standard_user | secret_sauce | sauceLabsBikeLight | Sauce Labs Bike Light |