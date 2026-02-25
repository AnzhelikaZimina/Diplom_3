package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class RecoveryPage extends BasePage {
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public RecoveryPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        click(loginLink);
    }
}