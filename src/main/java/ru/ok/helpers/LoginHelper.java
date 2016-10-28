package ru.ok.helpers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.ok.data.Account;

/**
 * Вспомогательные класс для авторизации
 * Created by Alexey Dybov on 26.10.16.
 */
public class LoginHelper {

    private WebDriver driver;
    private String startPage;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
        this.startPage = System.getProperty("webdriver.base.url");
    }

    public void loginAs(Account account) {
        driver.get(startPage);
        account.getApi().getAuth().auth();
        addCookiesToBrowser(account);
    }

    private void addCookiesToBrowser(Account account) {
        for(Cookie cookie: account.getWebDriverCookies()){
            driver.manage().addCookie(cookie);
        }
    }
}
