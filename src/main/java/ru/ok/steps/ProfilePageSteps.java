package ru.ok.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.ok.data.Account;
import ru.ok.pages.ProfilePage;

/**
 * Главная страница профиля
 * Created by Alexey Dybov on 28.10.16.
 */
public class ProfilePageSteps extends Steps {

    private ProfilePage profilePage;

    public ProfilePageSteps(WebDriver driver) {
        super(driver);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
    }

    /**
     * Открытие страницы профила
     */
    public void openProfilePage() {
        openPageUnchecked();
        profilePageShouldBeOpened();
    }

    /**
     * Открытие страницы
     */
    public void openPageUnchecked(){
        profilePage.open();
    }

    /**
     * Проверка открытия страницы
     */
    public void profilePageShouldBeOpened() {
        Assert.assertTrue("Не открылась главная страница профиля", profilePage.isPageOpened());
    }

    public void userDataShouldBeSameAs(Account account) {

    }
}
