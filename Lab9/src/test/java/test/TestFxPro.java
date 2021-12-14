package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.LoginPage;
import page.TradingPage;
import java.util.concurrent.TimeUnit;

public class TestFxPro {
    private WebDriver driver;
    private TradingPage fxProTradingPage;

    @BeforeMethod
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        String email = "Wanjawaluj111@gmail.com";
        String password = "sP22j8pQ_h$hyGy";
        fxProTradingPage = new LoginPage(driver)
                .openPage()
                .enterEmail(email)
                .enterPassword(password)
                .signIn()
                .selectDemoAccount();
    }

    @Test(description = "Change time")
    public void changeTimeAndReturnChanges() {

        fxProTradingPage.openTimeSettings()
                .changeTimeZoneTo12()
                .closeTimeSettings();

        String timeBeforeChanges = fxProTradingPage.getTime();

        fxProTradingPage.openTimeSettings()
                .changeTimeZoneTo11()
                .closeTimeSettings();

        String timeAfterChanges = fxProTradingPage.getTime();

        Assert.assertNotEquals(timeBeforeChanges, timeAfterChanges);
    }

    @Test(description = "Create order")
    public void createOrderAndReturnChanges() {

        fxProTradingPage.openCreateOrderMenu()
                .createOrder();

        Assert.assertTrue(fxProTradingPage.getOrders());

        fxProTradingPage.deleteOrder();
    }

    @AfterMethod
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
