package ru.ok.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.annotations.At;

/**
 * Страница настроек пользователя
 * Created by Alexey Dybov on 27.10.16.
 */
@At("/settings")
public class SettingsPage extends Page {

    @FindBy(css = ".user-settings")
    private WebElement userSettingsBlock;
    @FindBy(css = "[href*='UserProfileNew']")
    private WebElement userDataBlock;
    @FindBy(css = ".user-settings_i .textWrap")
    private WebElement userDataText;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Открытие страницы
     */
    public void open() {
        openAt();
    }

    /**
     * Проверка отображения блока настройки
     * @return
     */
    public boolean isPageOpened() {
        return waitForElementPresent(userSettingsBlock);
    }

    /**
     * Клик по кноке изменить напротив личных данных
     */
    public void clickUserDataBlock() {
        userDataBlock.click();
    }

    /**
     * Получает строку с личными данными пользователя
     * @return
     */
    public String getUserData() {
        return userDataText.getText();
    }
}
