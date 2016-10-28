package ru.ok.api;

import com.jayway.restassured.response.Response;
import ru.ok.data.Account;

import static com.jayway.restassured.RestAssured.given;

/**
 *
 * Created by Alexey Dybov on 26.10.16.
 */
public class Auth {

    private Account account;

    public Auth(Account account) {
        this.account = account;
    }

    public void auth() {
        Response resp1 = given()
            .header("Origin", "https://ok.ru")
            .header("Referer", "https://ok.ru/")
            .header("Host", "www.ok.ru")
            .formParam("st.originalaction", "https://ok.ru/dk?cmd=AnonymLogin&st.cmd=anonymLogin")
            .formParam("st.email", account.getLogin())
            .formParam("st.password", account.getPassword())
            .formParam("st.remember", "on")
            .log().ifValidationFails()
            .expect()
            .statusCode(302)
            .log().ifValidationFails()
            .post("https://www.ok.ru/https");

        Response resp2 = given()
            .redirects().follow(false)
            .formParam("st.posted", "set")
            .log().ifValidationFails()
            .expect()
            .statusCode(302)
            .log().ifValidationFails()
            .get(resp1.getHeader("Location"));


        if (resp2.getDetailedCookies() != null) {
            account.setCookies(resp2.getDetailedCookies());
        } else throw new Error("User ");
    }
}
