package ru.ok.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.ok.data.Gender;
import ru.ok.pages.Page;

import java.util.Calendar;

/**
 * Попап изменения личных данных
 * Created by Alexey Dybov on 27.10.16.
 */
public class UserDataPopup extends Page {

    @FindBy(css = "[id*='PopLayerEditUserProfileNewForm']")
    private WebElement popup;
    @FindBy(css = "[name='fr.name']")
    private WebElement firstNameField;
    @FindBy(css = "[name='fr.surname']")
    private WebElement lastNameField;
    @FindBy(css = "[name='fr.bday']")
    private WebElement bDayField;
    @FindBy(css = "[name='fr.bmonth']")
    private WebElement bMonthField;
    @FindBy(css = "[name='fr.byear']")
    private WebElement bYearField;
    @FindBy(css = "[name='fr.citySugg_SearchInput']")
    private WebElement cityResidenceField;
    @FindBy(css = "[name='fr.cityBSugg_SearchInput']")
    private WebElement cityBirthField;
    @FindBy(css = "[name='button_savePopLayerEditUserProfileNew']")
    private WebElement saveButton;

    private String genderField = "[name='fr.gender'][value='%s']";

    private String cityResidenceSuggests = "//*[@id='citySugg_SuggestItems']";
    private String cityBirthSuggests = "//*[@id='cityBSugg_SuggestItems']";
    private String cityResidenceFirstSuggest = cityResidenceSuggests + "/li[1]";
    private String cityBirthFirstSuggest = cityBirthSuggests + "/li[1]";
    private String cityResidenceSuggest = cityResidenceSuggests+ "/li[.//*[text()='%s']]";
    private String cityBirthSuggest = cityBirthSuggests+ "/li[.//*[text()='%s']]";

    public UserDataPopup(WebDriver driver) {
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
     * Вводит имя
     * @param firstName
     */
    public void setFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    /**
     * Вводит фамилию
     * @param lastName
     */
    public void setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    /**
     * Вводит дату рождения
     * @param birthday
     */
    public void setBirthday(Calendar birthday) {
        Select selectBDay = new Select(bDayField);
        selectBDay.selectByValue(String.valueOf(birthday.get(Calendar.DAY_OF_MONTH)));

        Select selectBMonth = new Select(bMonthField);
        selectBMonth.selectByValue(String.valueOf(birthday.get(Calendar.MONTH) + 1));

        Select selectBYear = new Select(bYearField);
        selectBYear.selectByValue(String.valueOf(birthday.get(Calendar.YEAR)));
    }

    /**
     * Выставляет пол
     * @param gender
     */
    public void setGender(Gender gender) {
        String genderSelector = String.format(genderField, gender.getValue());
        element(By.cssSelector(genderSelector)).click();
    }

    /**
     * Вводит место проживания
     * @param city
     */
    public void setCityOfResidence(String city) {
        cityResidenceField.clear();
        cityResidenceField.sendKeys(city);
    }

    /**
     * Вводит место рождения
     * @param city
     */
    public void setCityOfBirth(String city) {
        cityBirthField.clear();
        cityBirthField.sendKeys(city);
    }

    /**
     * Кликает на кнопку сохранить
     */
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Проверяет наличие списка саджестов у поля город проживания
     */
    public boolean cityOfResidenceSuggestsIsPresent() {
        return waitForElementPresent(By.xpath(cityResidenceFirstSuggest));
    }

    /**
     * Проверяет наличие списка саджестов у поля город рождения
     */
    public boolean cityOfBirthSuggestsIsPresent() {
        return waitForElementPresent(By.xpath(cityBirthFirstSuggest));
    }

    /**
     * Выбирает саджест из списка
     * @param city
     */
    public void selectResidenceSuggest(String city) {
        String locator = String.format(cityResidenceSuggest, city);
        element(By.xpath(locator)).click();
    }

    /**
     * Выбирает саджест из списка
     * @param city
     */
    public void selectBirthSuggest(String city) {
        String locator = String.format(cityBirthSuggest, city);
        element(By.xpath(locator)).click();
    }
}
