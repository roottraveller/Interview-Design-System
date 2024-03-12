package com.smartHome.domain.smartHomeDevices;

import com.smartHome.domain.devices.Device;

public class Alexa extends SmartHomeDevice {
    private Device smartCharger;

    public Alexa() {
    }

    public Alexa(Device smartCharger) {
        this.smartCharger = smartCharger;
    }

    public Device getSmartCharger() {
        return smartCharger;
    }

    public void setSmartCharger(Device smartCharger) {
        this.smartCharger = smartCharger;
    }
}
