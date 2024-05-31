Feature: Registrarse en parabank y verificar el registro
  Necesito registrarme en la página parabank
  Para validar que el registro fue exitoso

  Scenario: Registrarse en parabank
    Given Deseo abrir la pagina parabank "https://parabank.parasoft.com/"
    When ingreso a la opcion de Register
    When ingreso los siguientes datos para mi registro: First Name: "Caan", Last Name: "Hipe", Address: "12 Main St", City: "Anywhere", State: "Anystate", Zip Code: "12345678", Phone: "555-555-5555", SSN: "99-99-9999", Username: "caanHipe", Password: "password2121", Confirm: "password2121"
    When presiono el boton Open New Account y en el select escogemos "SAVINGS"
    When luego presiono el boton Open New Account
    When guardo el numero Your new account number
    Then valido que la cuenta exista en la opcion de Accounts Overview
