package pageobjects;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@Getter
public class RegistrationPage extends BasePage {
    private final By nameInput = By.xpath("//fieldset[1]//input");
    private final By emailInput = By.xpath("//fieldset[2]//input");
    private final By passwordInput = By.cssSelector("input[name='Пароль']");
    private final By registerButton = By.cssSelector("button.button_button__33qZ0");
    private final By loginLink = By.xpath("//a[text()='Войти']");
    private final By incorrectPassword = By.xpath("//fieldset[3]/div/p");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Печатаем имя")
    public void setName(String name) {
        type(nameInput, name);
    }

    @Step("Печатаем email")
    public void setEmail(String email) {
        type(emailInput, email);
    }

    @Step("Печатаем пароль")
    public void setPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Нажимаем на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        click(registerButton);
    }

    @Step("Нажимаем на кнопку входа")
    public void clickLoginLink() {
        click(loginLink);
    }

    @Step("Проверяем есть ли индикация некорректности пароля")
    public void checkIncorrectPassword() {
        waitForVisibility(incorrectPassword);
        assertEquals("Некорректный пароль", getDriver().findElement(incorrectPassword).getText().trim());
    }
}