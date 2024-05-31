package com.unac.pagesbank;

import com.unac.actions.Action;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://parabank.parasoft.com/parabank/openaccount.htm")
public class OpenAccount extends PageObject {

    private By openAccLink = By.linkText("Open New Account");
    private By openAccBtn = By.cssSelector("input[value='Open New Account']");
    private By accType = By.id("type");
    private By openNewAcctBtn = By.xpath("//input[@value='Open New Account']");
    private By newAccNumber = By.id("newAccountId");
    private By openAccountOverviewUri = By.linkText("Accounts Overview");

    public void clickOpenAccountLink() {
        Action.clickElement(getDriver(), openAccLink);
    }

    public void clickOpenAccountButton() {
        Action.clickElement(getDriver(), openAccBtn);
    }

    public void selectAccountType(String accountType) {
        Action.send(getDriver(), accType, accountType);
    }

    public void clickOpenNewAccountButton() {
        Action.clickElement(getDriver(), openNewAcctBtn);
    }

    public String getNewAccountNumber() {
        return getDriver().findElement(newAccNumber).getText();
    }

    public void clickOpenAccountOverviewLink() {
        Action.clickElement(getDriver(), openAccountOverviewUri);
    }
}
