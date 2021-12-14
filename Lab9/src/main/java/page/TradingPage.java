package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TradingPage extends BasePage {

    @FindBy(css = "#app > div.sidebar > section.sidebar__trailing > i.font-icon.icon_settings")
    private WebElement settingsButton;

    @FindBy(css = "#app > div.workspace-area > div:nth-child(3) > div > div > div > div:nth-child(2) > div > div > div > div > div > div:nth-child(1)")
    private WebElement timeZoneListButton;

    @FindBy(css = "#app > div.workspace-area > div:nth-child(3) > div:nth-child(2) > div > div > div:nth-child(2) > div > div > div > div > div > div.scrollable > div:nth-child(1)")
    private WebElement timeZoneItemButton12;

    @FindBy(css = "#app > div.workspace-area > div:nth-child(3) > div:nth-child(2) > div > div > div:nth-child(2) > div > div > div > div > div > div.scrollable > div:nth-child(3)")
    private WebElement timeZoneItemButton11;

    @FindBy(css = "#app > div.workspace-area > div:nth-child(3) > div:nth-child(2) > div > div > div.dialog-drag-bar > i")
    private WebElement exitTimeZoneListButton;

    @FindBy(css = "#app > div.workspace-area > div:nth-child(3) > div > div > div > div.dialog-drag-bar > i")
    private WebElement exitSettingsButton;

    @FindBy(css = "#app > div.workspace-area > div.workspace > div > div.layout-cell.horizontal > div:nth-child(3) > div.window.window-visible-overflow > div.tile.chart-tile.good.tile-window.widget-container > div > svg > g.axis.vertical > text:nth-child(5)")
    private WebElement timeWidget;

    @FindBy(css = "#app > div.sidebar > section.sidebar__leading > i.font-icon.icon_new_order")
    private WebElement createOrderMenuButton;

    @FindBy(css = "#app > div.workspace-area > div:nth-child(3) > div > div > div > div:nth-child(2) > div > div > div > div > section.actions > button")
    private WebElement createOrderButton;

    @FindBy(css = "#app > div.workspace-area > div.workspace > div > div.window-wrapper > div.window.window-overflow > div.widget-container > div > div > div.data-table-scroll.scroll-view > div.scrollable > div > div > span:nth-child(1)")
    private WebElement orderWidget;

    @FindBy(css = "#app > div.workspace-area > div.workspace > div > div.window-wrapper > div.window.window-overflow > div.widget-container > div > div > div.data-table-scroll.scroll-view > div.scrollable > div > div > span.data-table-cell.data-table-action-cell > button")
    private WebElement deleteOrderButton;

    protected TradingPage(WebDriver driver) {
        super(driver);
    }

    public TradingPage openTimeSettings() {
        waitForElementToBeClickable(driver, settingsButton);
        settingsButton.click();
        waitForElementToBeClickable(driver, timeZoneListButton);
        timeZoneListButton.click();
        return this;
    }

    public TradingPage changeTimeZoneTo12() {
        waitForElementToBeClickable(driver, timeZoneItemButton12);
        timeZoneItemButton12.click();
        return this;
    }

    public TradingPage changeTimeZoneTo11() {
        waitForElementToBeClickable(driver, timeZoneItemButton11);
        timeZoneItemButton11.click();
        return this;
    }

    public TradingPage closeTimeSettings() {
        waitForElementToBeClickable(driver, exitSettingsButton);
        exitSettingsButton.click();
        return this;
    }

    public String getTime() {
        waitForVisibilityOfElement(driver, timeWidget);
        return timeWidget.getText();
    }

    public TradingPage openCreateOrderMenu() {
        waitForElementToBeClickable(driver, createOrderMenuButton);
        createOrderMenuButton.click();
        return this;
    }

    public TradingPage createOrder() {
        waitForElementToBeClickable(driver, createOrderButton);
        createOrderButton.click();
        return this;
    }

    public boolean getOrders() {
        waitForVisibilityOfElement(driver, orderWidget);
        return orderWidget.isDisplayed();
    }

    public TradingPage deleteOrder() {
        waitForElementToBeClickable(driver, deleteOrderButton);
        deleteOrderButton.click();
        return this;
    }
}
