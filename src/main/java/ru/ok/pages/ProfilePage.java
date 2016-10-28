package ru.ok.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.annotations.At;

/**
 * Главная странице профиля
 * Created by Alexey Dybov on 28.10.16.
 */
@At("/feed")
public class ProfilePage extends Page {

    @FindBy(css = ".mctc_nameAndOnline")
    private WebElement nameField;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Окрытие страницы профиля
     */
    public void open() {
        openAt();
    }

    /**
     * Проверка отображения блока настройки
     * @return
     */
    public boolean isPageOpened() {
        return waitForElementPresent(nameField);
    }
}
