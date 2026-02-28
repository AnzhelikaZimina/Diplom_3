package test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobjects.AuthPage;
import pageobjects.ConstructorPage;
import pageobjects.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации пользователя с валидными данными")
    public void testSuccessfulRegistration() {
        String name = "TestUser";
        String email = "test" + System.currentTimeMillis() + "@test.com";
        String password = "123456";

        AuthPage authPage = register(name, email, password);
        assertTrue("Форма входа не открылась после регистрации", authPage.isLoginButtonVisible());
    }

    @Test
    @DisplayName("Ошибка при регистрации с некорректным паролем")
    @Description("Проверка ошибки при регистрации с паролем меньше 6 символов")
    public void testInvalidPasswordError() {
        String name = "TestUser";
        String email = "test" + System.currentTimeMillis() + "@test.com";
        String password = "12345";

        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickPersonalAccountButton();

        AuthPage authPage = new AuthPage(getDriver());
        authPage.clickRegisterLink();

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.clickRegisterButton();

        registrationPage.checkIncorrectPassword();
    }
}