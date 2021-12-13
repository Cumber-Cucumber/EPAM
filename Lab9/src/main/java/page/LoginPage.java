package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final String HOMEPAGE_URL = "https://edge.fxpro.com";

    @FindBy(css = "#container > div > div > div > form > div > input:nth-child(4)")
    private WebElement fieldForEmail;

    @FindBy(css = "#container > div > div > div > form > div > input:nth-child(5)")
    private WebElement fieldForPassword;

    @FindBy(css = "#container > div > div > div > form > div > button")
    private WebElement submitLogInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public LoginPage enterEmail(String email) {
        waitForVisibilityOfElement(driver, fieldForEmail);
        fieldForEmail.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        waitForVisibilityOfElement(driver, fieldForPassword);
        fieldForPassword.sendKeys(password);
        return this;
    }

    public SelectAccountPage signIn() {
        waitForElementToBeClickable(driver, submitLogInButton);
        submitLogInButton.click();
        return new SelectAccountPage(driver);
    }
}
