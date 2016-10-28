package ru.ok.data;

/**
 * Пол
 * Created by Alexey Dybov on 28.10.16.
 */
public enum Gender {

    Male("1"),
    Female("2");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
