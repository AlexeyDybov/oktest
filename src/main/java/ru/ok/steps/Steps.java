package ru.ok.steps;

import org.openqa.selenium.WebDriver;

/**
 * Вспомогательные методы в шагах
 * Created by Alexey Dybov on 27.10.16.
 */
public class Steps {

    protected WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Явное ожидание
     * @param timeout милисекунды
     */
    protected void wait(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
