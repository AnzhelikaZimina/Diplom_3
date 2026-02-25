package test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobjects.ConstructorPage;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка перехода к разделу 'Булки' в конструкторе")
    public void testSwitchToBunsSection() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        // булки по умолчанию, нужно перейти на другую секцию, чтоб проверить переход на булки
        constructorPage.clickFillingsSectionButton();

        constructorPage.clickBunSectionButton();
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка перехода к разделу 'Соусы' в конструкторе")
    public void testSwitchToSaucesSection() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickSaucesSectionButton();
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка перехода к разделу 'Начинки' в конструкторе")
    public void testSwitchToFillingsSection() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickFillingsSectionButton();
    }
}