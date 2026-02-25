package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@Getter
public class RegistrationPage extends BasePage {
    private final By nameInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordInput = By.cssSelector("input[name='Пароль']");
    private final By registerButton = By.cssSelector("button.button_button__33qZ0");
    private final By loginLink = By.xpath("//a[text()='Войти']");
    private final By incorrectPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        type(nameInput, name);
    }

    public void setEmail(String email) {
        type(emailInput, email);
    }

    public void setPassword(String password) {
        type(passwordInput, password);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public void checkIncorrectPassword() {
        waitForVisibility(incorrectPassword);
        assertEquals("Некорректный пароль", getDriver().findElement(incorrectPassword).getText().trim());
    }
}