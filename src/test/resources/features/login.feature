Feature: login en la pagina
  Como usuario quiero poder acceder al sistema

  Background:
    Given el usuario esta en la pagina de login

  Scenario: el usuario suministra credenciales correctas
    When escribe el nombre de usuario "standard_user"
    And escribe la clave "secret_sauce"
    And pulsa el boton Login
    Then el sistema muestra la pagina principal

   Scenario Outline: el usuario suministra credenciales incorrectas
     When escribe el nombre de usuario "<usuario>"
     And escribe la clave "<clave>"
     And pulsa el boton Login
     Then el sistema muestra el error de credenciales incorrectas

     Examples:
     | usuario       | clave        |
     | standard_use  | secret_sauce |
     | standard_user | secretsauce  |
     | standard_use  | secret_sauc  |

     Scenario: el usuario suministra el nombre de usuario vacio
       When escribe el nombre de usuario ""
       And escribe la clave "secret_sauce"
       And pulsa el boton Login
       Then el sistema muestra el error de usuario en blanco

  Scenario: el usuario suministra la clave vacia
    When escribe el nombre de usuario "standard_user"
    And escribe la clave ""
    And pulsa el boton Login
    Then el sistema muestra el error de clave en blanco