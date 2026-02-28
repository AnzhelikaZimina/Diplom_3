package pageobjects;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private final WebDriverWait wait;

    private final By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.DEFAULT_TIMEOUT);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void waitForVisibility(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        waitForVisibility(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        waitForVisibility(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateToConstructor() {
        waitForVisibility(constructorButton);
        click(constructorButton);
    }

    protected WebDriverWait getWait() {
        return wait;
    }
}