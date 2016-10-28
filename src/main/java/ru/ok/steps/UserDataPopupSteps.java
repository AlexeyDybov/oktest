package ru.ok.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.ok.data.City;
import ru.ok.data.Gender;
import ru.ok.elements.UserDataPopup;

import java.util.Calendar;

/**
 * Шаги для работы с попапом изменения личных данных
 * Created by Alexey Dybov on 27.10.16.
 */
public class UserDataPopupSteps extends Steps{

    private UserDataPopup userDataPopup;

    public UserDataPopupSteps(WebDriver driver) {
        super(driver);
        userDataPopup = PageFactory.initElements(driver, UserDataPopup.class);
    }

    /**
     * Проверяет видимость попапа на странице
     */
    public void userDataPopupShouldBePresent() {
        Assert.assertTrue("Должен быть открыть попап изменения личных данных",
            userDataPopup.isPopupPresent());
    }

    /**
     * Проверяет отсутствие попапа на странице
     */
    public void userDataPopupShouldNotBePresent() {
        Assert.assertTrue("Попап изменения личных данных не должен отображаться на странице",
            userDataPopup.isPopupNotPresent());
    }

    /**
     * Вводит имя
     * @param firstName
     */
    public void setFirstName(String firstName) {
        userDataPopup.setFirstName(firstName);
    }

    /**
     * Вводит фамилию
     * @param lastName
     */
    public void setLastName(String lastName) {
        userDataPopup.setLastName(lastName);
    }

    /**
     * Вводит дату рождения
     * @param birthday
     */
    public void setBirthday(Calendar birthday) {
        userDataPopup.setBirthday(birthday);
    }

    /**
     * Выставляет пол
     * @param gender
     */
    public void setGender(Gender gender) {
        userDataPopup.setGender(gender);
    }

    /**
     * Вводит место проживания
     * @param city
     */
    public void setCityOfResidence(City city) {
        userDataPopup.setCityOfResidence(city);
    }

    /**
     * Вводит место рождения
     * @param city
     */
    public void setCityOfBirth(City city) {
        userDataPopup.setCityOfBirth(city);
    }

    /**
     * Жмет кнопку сохранить
     */
    public void clickSaveButton() {
        userDataPopup.clickSaveButton();
    }
}
