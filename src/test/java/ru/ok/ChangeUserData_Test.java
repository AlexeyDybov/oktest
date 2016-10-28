package ru.ok;

import org.junit.Before;
import org.junit.Test;
import qa.driver.WebDriverFactory;
import ru.ok.data.Account;
import ru.ok.data.City;
import ru.ok.data.Gender;
import ru.ok.helpers.LoginHelper;
import ru.ok.steps.NotifyPopupSteps;
import ru.ok.steps.SettingsSteps;
import ru.ok.steps.UserDataPopupSteps;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Смена личных данных пользователя
 */
public class ChangeUserData_Test extends BaseTest {

    private LoginHelper loginHelper;
    private SettingsSteps settingsSteps;
    private UserDataPopupSteps userDataPopupSteps;
    private NotifyPopupSteps notifyPopupSteps;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriverInstance();
        loginHelper = new LoginHelper(driver);
        settingsSteps = new SettingsSteps(driver);
        userDataPopupSteps = new UserDataPopupSteps(driver);
        notifyPopupSteps = new NotifyPopupSteps(driver);
    }

    @Test
    public void changeUserData() {
        Account account = new Account("79162143406", "qwerty123");
        loginHelper.loginAs(account);

        Account oldAccount = new Account();
        oldAccount.setFirstName("Вася");
        oldAccount.setLastName("Васин");
        oldAccount.setBirthDate(new GregorianCalendar(1988, Calendar.JANUARY, 1));
        oldAccount.setGender(Gender.Male);
        oldAccount.setCityOfBirth(City.SaintPetersburg);
        oldAccount.setCityOfResidence(City.SaintPetersburg);

        settingsSteps.openSettingsPage();
        settingsSteps.clickUserData();

        userDataPopupSteps.userDataPopupShouldBePresent();
        userDataPopupSteps.setFirstName(oldAccount.getFirstName());
        userDataPopupSteps.setLastName(oldAccount.getLastName());
        userDataPopupSteps.setBirthday(oldAccount.getBirthDate());
        userDataPopupSteps.setGender(oldAccount.getGender());
        userDataPopupSteps.setCityOfResidence(oldAccount.getCityOfResidence());
        userDataPopupSteps.setCityOfBirth(oldAccount.getCityOfBirth());
        userDataPopupSteps.clickSaveButton();
        userDataPopupSteps.userDataPopupShouldNotBePresent();

        notifyPopupSteps.notifyPopupShouldBePresent();
        notifyPopupSteps.clickCloseButton();

        settingsSteps.userDataShouldBeSameAs(oldAccount);

        Account newAccount = new Account();
        newAccount.setFirstName("Петя");
        newAccount.setLastName("Петин");
        newAccount.setBirthDate(new GregorianCalendar(1986, Calendar.SEPTEMBER, 3));
        newAccount.setGender(Gender.Female);
        newAccount.setCityOfBirth(City.Pushkin);
        newAccount.setCityOfResidence(City.Pushkin);

        settingsSteps.openSettingsPage();
        settingsSteps.clickUserData();

        userDataPopupSteps.userDataPopupShouldBePresent();
        userDataPopupSteps.setFirstName(newAccount.getFirstName());
        userDataPopupSteps.setLastName(newAccount.getLastName());
        userDataPopupSteps.setBirthday(newAccount.getBirthDate());
        userDataPopupSteps.setGender(newAccount.getGender());
        userDataPopupSteps.setCityOfResidence(newAccount.getCityOfResidence());
        userDataPopupSteps.setCityOfBirth(newAccount.getCityOfBirth());
        userDataPopupSteps.clickSaveButton();
        userDataPopupSteps.userDataPopupShouldNotBePresent();

        settingsSteps.userDataShouldBeSameAs(newAccount);
    }
}
