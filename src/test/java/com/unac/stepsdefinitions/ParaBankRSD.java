package com.unac.stepsdefinitions;

import com.unac.pagesbank.HomePage;
import com.unac.pagesbank.OpenAccount;
import com.unac.pagesbank.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParaBankRSD {

    private HomePage hPage;
    private RegisterPage rPage;
    private OpenAccount oAccount;
    private static String newAccountNumber;

    @Given("Deseo abrir la pagina parabank {string}")
    public void deseo_abrir_la_pagina_parabank(String url) {
        hPage.navigateTo(url);
    }

    @When("ingreso a la opcion de Register")
    public void ingreso_a_la_opcion_de_register() {
        hPage.clickRegister();
    }

    @When("ingreso los siguientes datos para mi registro: First Name: {string}, Last Name: {string}, Address: {string}, City: {string}, State: {string}, Zip Code: {string}, Phone: {string}, SSN: {string}, Username: {string}, Password: {string}, Confirm: {string}")
    public void ingreso_los_siguientes_datos_para_mi_registro(String name, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password, String confirm) {
        rPage.register(name, lastName, address, city, state, zipCode, phone, ssn, username, password, confirm);
    }

    @When("presiono el boton Open New Account y en el select escogemos {string}")
    public void presiono_el_boton_open_new_account(String accountType) {
        oAccount.clickOpenAccountLink();
        oAccount.clickOpenAccountButton();
        oAccount.selectAccountType(accountType);
        await(4);
    }

    @When("luego presiono el boton Open New Account")
    public void luego_presiono_el_boton_open_new_account() {
        oAccount.clickOpenNewAccountButton();
    }

    @When("guardo el numero Your new account number")
    public void guardo_el_numero_your_new_account_number() {
        newAccountNumber = oAccount.getNewAccountNumber();
    }

    @Then("valido que la cuenta exista en la opcion de Accounts Overview")
    public void valido_que_la_cuenta_exista_en_la_opcion_de_accounts_overview() {
        oAccount.clickOpenAccountOverviewLink();
        WebElement accountNumberElement = oAccount.getDriver().findElement(By.linkText(newAccountNumber));
        String message = accountNumberElement.isDisplayed()
                ? "El id de la cuenta " + newAccountNumber + " esta presente en la pagina Accounts Overview."
                : "El  id de la cuenta " + newAccountNumber + " no se encuentra en la página Accounts Overview.";
        System.out.println(message);
    }

    @After
    public static void closeBrowser() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        if (driver != null) {
            printAccountNumber();
            driver.quit();
        }
    }

    private static void printAccountNumber() {
        if (newAccountNumber != null) {
            System.out.println("Account Number: " + newAccountNumber);
        }
    }

    private void await(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
