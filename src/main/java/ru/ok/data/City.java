package ru.ok.data;

/**
 * Город
 * Created by Alexey Dybov on 28.10.16.
 */
public enum City {

    SaintPetersburg("Санкт-Петербург","Санкт-Петербург, Россия"),
    Pushkin("г. Пушкин (Санкт-Петербург г)","г. Пушкин (Санкт-Петербург г), Россия");

    private String shortName;
    private String fullName;

    City(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }
}
