# qa-selenium-project

UI-тесты для Stellar Burgers с Page Object и Allure-отчётом.

## Структура

- `src/test/java/constants/` — константы (URL, таймауты)
- `src/test/java/pageobjects/` — Page Object классы
- `src/test/java/test/` — тесты

## Запуск

```bash
# Chrome (по умолчанию)
mvn test

# Яндекс Браузер
mvn test -Dbrowser=yandex -Dwebdriver.chrome.drive=путь к драйверу ЯндексБраузера
```
