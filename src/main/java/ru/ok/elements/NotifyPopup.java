package ru.ok.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ok.pages.Page;

/**
 * Created by Alexey Dybov on 28.10.16.
 */
public class NotifyPopup extends Page{

    @FindBy(css = "[id='notifyPanelId']")
    private WebElement popup;
    @FindBy(css = "[id='buttonId_button_close']")
    private WebElement closeButton;

    public NotifyPopup(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверяет отображение попапа
     * @return
     */
    public boolean isPopupPresent() {
        return waitForElementPresent(popup);
    }

    /**
     * Проверяет отсутствие попапа
     * @return
     */
    public boolean isPopupNotPresent() {
        return waitForElementNotPresent(popup);
    }

    /**
     * Клик по кнопке закрыть
     */
    public void clickCloseButton() {
        closeButton.click();
    }
}
