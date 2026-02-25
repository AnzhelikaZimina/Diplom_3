package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class ConstructorPage extends BasePage {
    private final By personalAccountButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a");
    private final By bunSectionButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    private final By saucesSectionButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    private final By fillingsSectionButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");
    private final By bunSectionHeader = By.xpath("//h2[text()='Булки']");
    private final By saucesSectionHeader = By.xpath("//h2[text()='Соусы']");
    private final By fillingsSectionHeader = By.xpath("//h2[text()='Начинки']");

    private final By mainPageButton = By.xpath("//a[text()='Конструктор']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By loadingOverlay = By.xpath("//*[@id=\"root\"]/div/div/div");
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    private void waitForElementToBeClickable(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickPersonalAccountButton() {
        waitForElementToBeClickable(personalAccountButton);
        click(personalAccountButton);
    }

    private void clickSectionButton(By locator) {
        click(locator);
        getWait().until(ExpectedConditions.attributeContains(locator, "class", "tab_tab_type_current"));
    }

    public void clickBunSectionButton() {
        clickSectionButton(bunSectionButton);
    }

    public void clickSaucesSectionButton() {
        clickSectionButton(saucesSectionButton);
    }

    public void clickFillingsSectionButton() {
        clickSectionButton(fillingsSectionButton);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean isOrderButtonVisible() {
        return isElementVisible(orderButton);
    }

    public void waitForOrderButtonToBeVisible() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }
}