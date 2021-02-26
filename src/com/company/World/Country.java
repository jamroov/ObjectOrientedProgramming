package com.company.World;

public enum Country {
    BLR("Belarusian", "ISO 3166-2:BY", 54.4),
    BRA("Portugese", "ISO 3166-2:BR", 2044.0),
    DOM("Spanish", "ISO 3166-2:DO", 75.0);

    public final String language;
    public final String code;
    public final Double gdp; //In billions of USD


    Country(String language, String code, Double gdp) {
        this.language = language;
        this.code = code;
        this.gdp = gdp;
    }

    public Double gdpInPln() {
        Double res = this.gdp * 3.74;
        System.out.println(String.format("GDP in PLN: %.2f", res));
        return this.gdp * 3.74;
    }
}
