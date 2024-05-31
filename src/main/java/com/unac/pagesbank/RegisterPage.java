package com.unac.pagesbank;

import com.unac.actions.Action;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://parabank.parasoft.com/parabank/index.htm")
public class RegisterPage extends PageObject {

    By firstName = By.name("customer.firstName");
    By lastName = By.name("customer.lastName");
    By address = By.name("customer.address.street");
    By city = By.name("customer.address.city");
    By state = By.name("customer.address.state");
    By zipCode = By.name("customer.address.zipCode");
    By phoneNumber = By.name("customer.phoneNumber");
    By ssn = By.name("customer.ssn");
    By username = By.name("customer.username");
    By password = By.name("customer.password");
    By confirm = By.name("repeatedPassword");
    By registerButton = By.xpath("//input[@value='Register']");

    public void register(
            String FirstName,
            String LastName,
            String Address,
            String City,
            String State,
            String ZipCode,
            String PhoneNumber,
            String SSN,
            String Username,
            String Password,
            String Confirm) {

        Action.send(getDriver(), firstName, FirstName);
        Action.send(getDriver(), lastName, LastName);
        Action.send(getDriver(), address, Address);
        Action.send(getDriver(), city, City);
        Action.send(getDriver(), state, State);
        Action.send(getDriver(), zipCode, ZipCode);
        Action.send(getDriver(), phoneNumber, PhoneNumber);
        Action.send(getDriver(), ssn, SSN);

        String uniqueUsername = Action.generateId(Username);
        Action.send(getDriver(), username, uniqueUsername);
        Action.send(getDriver(), password, Password);
        Action.send(getDriver(), confirm, Confirm);

        Action.clickElement(getDriver(), registerButton);
    }
}
