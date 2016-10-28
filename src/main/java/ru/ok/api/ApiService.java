package ru.ok.api;

import ru.ok.data.Account;

/**
 *
 * Created by Alexey Dybov on 26.10.16.
 */
public class ApiService {

    private Auth auth;
    private UserConfig userConfig;
    private Account account;

    public ApiService(Account account) {
        this.account = account;
    }

    public Auth getAuth() {
        if (auth == null) {
            auth = new Auth(account);
        }
        return auth;
    }

    public UserConfig getUserConfig() {
        if (userConfig == null) {
            userConfig = new UserConfig(account);
        }
        return userConfig;
    }
}
