package test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobjects.ConstructorPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка перехода к разделу 'Булки' в конструкторе")
    public void testSwitchToBunsSection() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        // булки по умолчанию, нужно перейти на другую секцию, чтоб проверить переход на булки
        constructorPage.clickFillingsSectionButton();

        constructorPage.clickBunSectionButton();

        assertTrue("Переход на секцию Булки не произошёл", constructorPage.getBunsSectionHighlighted());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка перехода к разделу 'Соусы' в конструкторе")
    public void testSwitchToSaucesSection() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickSaucesSectionButton();
        assertTrue("Переход на секцию Соусы не произошёл", constructorPage.getSaucesSectionHighlighted());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка перехода к разделу 'Начинки' в конструкторе")
    public void testSwitchToFillingsSection() {
        ConstructorPage constructorPage = new ConstructorPage(getDriver());
        constructorPage.clickFillingsSectionButton();
        assertTrue("Переход на секцию Начинки не произошёл", constructorPage.getFillingsSectionHighlighted());
    }
}