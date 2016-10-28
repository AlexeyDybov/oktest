package ru.ok.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.ok.elements.NotifyPopup;

/**
 * Шаги для работы с попапо
 * Created by Alexey Dybov on 28.10.16.
 */
public class NotifyPopupSteps extends Steps {

    private NotifyPopup notifyPopup;

    public NotifyPopupSteps(WebDriver driver) {
        super(driver);
        notifyPopup = PageFactory.initElements(driver, NotifyPopup.class);
    }

    /**
     * Проверка отображения попапа
     */
    public void notifyPopupShouldBePresent() {
        Assert.assertTrue("Должен отображаться попап с уведомлением", notifyPopup.isPopupPresent());
    }

    /**
     * Клик по кнопке закрыть
     */
    public void clickCloseButton() {
        notifyPopup.clickCloseButton();
    }
}
