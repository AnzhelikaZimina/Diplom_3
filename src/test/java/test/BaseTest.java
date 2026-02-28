package test;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AuthPage;
import pageobjects.ConstructorPage;
import pageobjects.RegistrationPage;

public class BaseTest {
    private WebDriver driver;

    @BeforeClass
    public static void globalSetup() {
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";
    }

    @Before
    public void setUp() {
        if ("chrome".equals(System.getProperty("browser", "chrome"))) {
            driver = createChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "F:/Dowloads/yandexdriver-23.9.0.2208-win/yandexdriver.exe");
            driver = new ChromeDriver();
        }

        driver.get(Constants.BASE_URL);
    }

    private WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    @After
    public void teardown() {
        if (getDriver() != null) {
            driver.quit();
        }
    }

    protected AuthPage register(String name, String email, String password) {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickPersonalAccountButton();

        AuthPage authPage = new AuthPage(getDriver());
        authPage.clickRegisterLink();

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.clickRegisterButton();

        authPage.waitForLoginButtonToBeVisible();
        return authPage;
    }
}