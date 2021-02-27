package com.company.World;

public enum CountryEnum {
    BLR("Belarusian", "ISO 3166-2:BY", 54.4, 207600.0),
    BRA("Portugese", "ISO 3166-2:BR", 2044.0,8516000.0),
    DOM("Spanish", "ISO 3166-2:DO", 75.0, 48442.00),
    HRV("Croatian", "ISO 3166-2:CN", 54.5, 56594.00),
    FIN("Finnish", "ISO 3166-2:FI", 253.0, 338440.00);

    public final String language;
    public final String code;
    public final Double gdp; //In billions of USD
    public final Double area;


    CountryEnum(String language, String code, Double gdp, Double area) {
        this.language = language;
        this.code = code;
        this.gdp = gdp;
        this.area = area;
    }

    public Double gdpInPln() {
        Double res = this.gdp * 3.74;
        System.out.println(String.format("GDP in PLN: %.2f", res));
        return this.gdp * 3.74;
    }
}
