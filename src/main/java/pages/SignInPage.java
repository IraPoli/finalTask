package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(xpath = "//input[@name='userid']")
    private WebElement userNameItem;


    @FindBy(xpath = "//input[@name='pass']")
    private WebElement passwordItem;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueButton;


    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement singInButton;

    @FindBy(xpath = "//button[@id='webauthn-maybe-later-link']")
    private WebElement maybeLaterButton;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void isUserNameItemVisible() {
        userNameItem.isDisplayed();
    }

    public void enterUserNameItem(final String userName) {
        userNameItem.clear();
        userNameItem.sendKeys(userName);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickSingInButton() {
        singInButton.click();
    }

    public void clickMaybeLaterButton() {
        maybeLaterButton.click();
    }


    public void enterPasswordItem(final String userName) {
        passwordItem.clear();
        passwordItem.sendKeys(userName);
    }


    public WebElement getUserNameItem() {
        return userNameItem;
    }

    public WebElement getPasswordItem() {
        return passwordItem;
    }


}
