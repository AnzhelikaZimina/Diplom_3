package pageobjects;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class ConstructorPage extends BasePage {
    private final By personalAccountButton = By.xpath("//nav/a");
    private final By bunSectionButton = By.xpath("//span[text()='Булки']//parent::div");
    private final By saucesSectionButton = By.xpath("//span[text()='Соусы']//parent::div");
    private final By fillingsSectionButton = By.xpath("//span[text()='Начинки']//parent::div");
    private final By bunSectionHeader = By.xpath("//h2[text()='Булки']");
    private final By saucesSectionHeader = By.xpath("//h2[text()='Соусы']");
    private final By fillingsSectionHeader = By.xpath("//h2[text()='Начинки']");

    private final By mainPageButton = By.xpath("//a[text()='Конструктор']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By loadingOverlay = By.xpath("//*[@id=\"root\"]/div/div/div");
    private final By loginButton = By.xpath("//main/section[2]/div/button");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    private void waitForElementToBeClickable(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Step("Нажимаем на кнопку 'Личный Кабинет'")
    public void clickPersonalAccountButton() {
        waitForElementToBeClickable(personalAccountButton);
        click(personalAccountButton);
    }

    private void clickSectionButton(By locator) {
        click(locator);
        getWait().until(ExpectedConditions.attributeContains(locator, "class", "tab_tab_type_current"));
    }

    @Step("Переходим на секцию Булки")
    public void clickBunSectionButton() {
        clickSectionButton(bunSectionButton);
    }

    @Step("Переходим на секцию Соусы")
    public void clickSaucesSectionButton() {
        clickSectionButton(saucesSectionButton);
    }

    @Step("Переходим на секцию Начинки")
    public void clickFillingsSectionButton() {
        clickSectionButton(fillingsSectionButton);
    }

    @Step("Проверяем переход на секцию Булки")
    public boolean getBunsSectionHighlighted() {
        return getDriver().findElement(bunSectionButton).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверяем переход на секцию Соусы")
    public boolean getSaucesSectionHighlighted() {
        return getDriver().findElement(saucesSectionButton).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверяем переход на секцию Начинки")
    public boolean getFillingsSectionHighlighted() {
        return getDriver().findElement(fillingsSectionButton).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Кликаем на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Проверяем кнопку 'Сделать заказ' на видимость")
    public boolean isOrderButtonVisible() {
        return isElementVisible(orderButton);
    }

    @Step("Ждём пока кнопка 'Сделать заказ' станет видимой")
    public void waitForOrderButtonToBeVisible() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }
}