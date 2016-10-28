package ru.ok.api;

import com.jayway.restassured.response.Response;
import ru.ok.data.Account;

import static com.jayway.restassured.RestAssured.given;

/**
 *
 * Created by Alexey Dybov on 26.10.16.
 */
public class UserConfig {

    private Account account;

    public UserConfig(Account account) {
        this.account = account;
    }

    public void changeUserInfo() {
        Response resp1 = given()
//            .redirects().follow(true)
            .cookies(account.getCookies())
            .header("Origin", "https://ok.ru")
            .header("Referer", "https://ok.ru/")
            .header("Host", "www.ok.ru")
            .header("TKN", "l4ljxAK_P3DAEkx4vsPddiFSoGNmMq8T")
            .formParam("st.layer.posted", "set")
//            .formParam("st.posted", "set")
            .formParam("fr.name","Васяв")
            .formParam("fr.surname","collector")
            .formParam("fr.bday","3")
            .formParam("fr.bmonth","2")
            .formParam("fr.byear","1988")
            .formParam("fr.gender","1")
            .formParam("fr.citySugg_SearchInput","Санкт-Петербург, Россия")
            .formParam("fr.cityBSugg_SearchInput","Санкт-Петербург, Россия")
            .formParam("fr.citySugg_CountryId","10414533690")
            .formParam("fr.citySugg_LocationText","Санкт-Петербург")
            .formParam("fr.citySugg_CityId","10399843062")
            .formParam("fr.cityBSugg_CountryId","10414533690")
            .formParam("fr.cityBSugg_LocationText","Санкт-Петербург")
            .formParam("fr.cityBSugg_CityId","")
//            .queryParam("st.cmd","userConfig")
//            .queryParam("cmd","PopLayer")
//            .queryParam("st.layer.cmd","PopLayerEditUserProfileNew")
//            .formParam("gwt.requested","63bc8cb6")
//            .queryParam("p_sId","0")
            .log().all()
            .expect()
            .statusCode(200)
            .log().all()
            .when()
            .post("https://ok.ru/dk?st.cmd=userConfig&amp;cmd=PopLayer&amp;st.layer.cmd=PopLayerEditUserProfileNew");
    }
}