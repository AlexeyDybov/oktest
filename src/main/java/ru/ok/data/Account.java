package ru.ok.data;

import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import ru.ok.api.ApiService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Account {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Calendar birthDate;
    private City cityOfResidence;
    private City cityOfBirth;
    private Cookies cookies;
    private ApiService apiService;

    public Account() {
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public ApiService getApi() {
        if (apiService == null) {
            apiService = new ApiService(this);
        }
        return apiService;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public List<org.openqa.selenium.Cookie> getWebDriverCookies() {
        List<org.openqa.selenium.Cookie> selCookies = new ArrayList<>();
        for (Cookie cookie : cookies) {
            selCookies.add(new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), cookie.getExpiryDate(), cookie.isHttpOnly()));
        }
        return selCookies;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    public City getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(City cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public City getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(City cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
}
