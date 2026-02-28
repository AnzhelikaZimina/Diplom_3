package pageobjects;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class AuthPage extends BasePage {
    private final By emailInput = By.cssSelector("input[name='name']");
    private final By passwordInput = By.cssSelector("input[name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By registerLink = By.cssSelector("a.Auth_link__1fOlj");
    private final By recoveryLink = By.cssSelector("a[href='/forgot-password']");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вводим email")
    public void setEmail(String email) {
        type(emailInput, email);
    }

    @Step("Вводим пароль")
    public void setPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Нажимаем на кнопку входа")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Нажимаем на ссылку регистрации")
    public void clickRegisterLink() {
        click(registerLink);
    }

    @Step("Нажимаем на ссылку восстановления пароля")
    public void clickRecoveryLink() {
        click(recoveryLink);
    }

    @Step("Ждём пока не появится кнопка входа")
    public void waitForLoginButtonToBeVisible() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    @Step("Проверяем кнопку входа на видимость")
    public boolean isLoginButtonVisible() {
        return isElementVisible(loginButton);
    }
}