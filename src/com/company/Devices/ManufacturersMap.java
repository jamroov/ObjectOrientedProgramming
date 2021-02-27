package com.company.Devices;

import java.util.ArrayList;
import java.util.HashMap;

public class ManufacturersMap {
    public HashMap<String, ArrayList<Device>> deviceByManufacturer = new HashMap<>();

    public ManufacturersMap() {
    }

    public void addDeviceToMap(String manufacturer, Device device) {
        if (this.deviceByManufacturer.containsKey(manufacturer)) {
            this.deviceByManufacturer.get(manufacturer).add(device);
        }
        else {
            this.deviceByManufacturer.put(manufacturer, new ArrayList<>());
            this.deviceByManufacturer.get(manufacturer).add(device);
        }
    }

    public ArrayList<Device> getDevicesByManuf(String manufacturer) {
        return this.deviceByManufacturer.getOrDefault(manufacturer, null);
    }
}
