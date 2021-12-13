package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectAccountPage extends BasePage {

    @FindBy(css = "#app > div:nth-child(2) > div > div > div > div.account-select-dialog > div.accounts-to-select-list.desktop-view > div > div.scrollable > div:nth-child(2)")
    private WebElement demoAccountButton;

    protected SelectAccountPage(WebDriver driver) {
        super(driver);
    }

    public TradingPage selectDemoAccount() {
        waitForVisibilityOfElement(driver, demoAccountButton);
        demoAccountButton.click();
        return new TradingPage(driver);
    }
}
