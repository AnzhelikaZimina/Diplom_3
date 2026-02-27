package test;

import api.UserApi;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.AuthPage;
import pageobjects.ConstructorPage;
import pageobjects.RecoveryPage;
import pageobjects.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private String email;
    private String password;

    @Before
    public void setUp() {
        super.setUp();
        String name = "TestUser";
        String email = "test" + System.currentTimeMillis() + "@test.com";
        String password = "123456";

        UserApi.createUser(email, password, name);

        this.email = email;
        this.password = password;
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    @Description("Проверка входа через кнопку 'Личный кабинет'")
    public void testLoginFromPersonalAccount() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickPersonalAccountButton();

        login();
    }

    private void login() {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.setEmail(email);
        authPage.setPassword(password);
        authPage.clickLoginButton();

        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.waitForOrderButtonToBeVisible();
        assertTrue("Пользователь не авторизовался", constructorPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверка входа через кнопку 'Войти' в форме регистрации")
    public void testLoginFromRegistrationForm() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickPersonalAccountButton();

        AuthPage authPage = new AuthPage(getDriver());
        authPage.clickRegisterLink();

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.clickLoginLink();

        login();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка входа через кнопку 'Войти' в форме восстановления пароля")
    public void testLoginFromRecoveryForm() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickPersonalAccountButton();

        AuthPage authPage = new AuthPage(getDriver());
        authPage.clickRecoveryLink();

        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        recoveryPage.clickLoginLink();

        login();
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт'")
    @Description("Проверка входа через кнопку 'Войти в аккаунт' на странице конструктора")
    public void testLoginFromButtonOnConstructorPage() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickLoginButton();

        login();
    }

    @After
    public void teardown() {
        super.teardown();
        UserApi.deleteAllCreatedUsers();
    }

}