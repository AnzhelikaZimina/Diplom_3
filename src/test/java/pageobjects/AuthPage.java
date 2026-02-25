package pageobjects;

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

    public void setEmail(String email) {
        type(emailInput, email);
    }

    public void setPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void clickRegisterLink() {
        click(registerLink);
    }

    public void clickRecoveryLink() {
        click(recoveryLink);
    }

    public void waitForLoginButtonToBeVisible() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    public boolean isLoginButtonVisible() {
        return isElementVisible(loginButton);
    }
}