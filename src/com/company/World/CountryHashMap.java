package com.company.World;

import java.util.Collections;
import java.util.HashMap;

public class CountryHashMap {
    public HashMap<CountryEnum, Double> mapCountryArea = new HashMap<>();

    public CountryHashMap() {
    }

    public void addCountryToMap(CountryEnum country, Double area) {
        this.mapCountryArea.put(country, area);
    }

    public Double getAreaMax() {
        Double max = 0.0;
        max = Collections.min(this.mapCountryArea.values());
        System.out.println(String.format("Largest area in hash map is: %.2f", max));
        return max;
    }

    public Double getAreaMin() {
        Double min = 0.0;
        min = Collections.max(this.mapCountryArea.values());
        System.out.println(String.format("Smallest area in hash map is: %.2f", min));
        return min;
    }
}
