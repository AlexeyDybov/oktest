package ru.ok.helpers;

import ru.ok.data.Gender;
import ru.ok.steps.ProfilePageSteps;
import ru.ok.steps.SettingsSteps;

import java.io.SyncFailedException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * Created by Alexey Dybov on 28.10.16.
 */
public class LangHelper {

    private ResourceBundle resourceBundle;

    public LangHelper(Class<?> aClass) {
        String lang = System.getProperty("lang", "ru");
        Locale locale = new Locale(lang);
        this.resourceBundle = ResourceBundle.getBundle(aClass.getSimpleName(), locale);
    }

    private MessageFormat getMessageFormat(String key) {
        try {
            return new MessageFormat(new String(resourceBundle.getString(key).getBytes("ISO-8859-1"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    /**
     * Возвращает вариант склонения существительного после числительного
     * @param count
     * @return
     * 1 год = 0(для определенных значений, когда единственное число);
     * 21 год = 1;
     * 43 года = 2;
     * 48 лет = 3;
     */
    public static int plurals(int count) {
        if (count == 1) return 0;
        if (count >= 11 && count <= 19) return 3;
        else {
            int i = count % 10;
            if (i == 1) return 1;
            else if (i > 1 && i <= 4) return 2;
            else return 3;
        }
    }

    public String getMessage(String key) {
        return getMessageFormat(key).toPattern();
    }

    public String getMessage(String key, Object... param) {
        List<Object> objectList = new ArrayList<>();
        for (Object par : param) {
            if (par instanceof Integer) {
                objectList.add(par);
                objectList.add(LangHelper.plurals((Integer) par));
            } else if (par.equals(Gender.Female)) {
                objectList.add(par);
                objectList.add(1);
            } else {
                objectList.add(par);
                objectList.add(0);
            }
        }
        return getMessageFormat(key).format(objectList.toArray());
    }
}
