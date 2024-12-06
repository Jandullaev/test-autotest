package com.epam.project.framework.properties;

public enum Region {
    UZBEKISTAN("Uzbekistan", "UZS"),
    KAZAKHSTAN("Kazakhstan", "KZT"),
    GEORGIA("Georgia", "GEL"),
    UKRAINE("Ukraine", "UAH"),
    CHINA("China", "CNY");

    private final String name;
    private final String currency;

    Region(String name, String currency) {
        this.name = name;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }
}