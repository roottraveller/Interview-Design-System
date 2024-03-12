package com.smartHome.domain.smartHomeDevices;

import com.smartHome.domain.devices.Device;

public class GoogleHome extends com.smartHome.domain.smartHomeDevices.SmartHomeDevice {

    private Device smartCharger;

    public GoogleHome() {
    }

    public GoogleHome(Device smartCharger) {
        this.smartCharger = smartCharger;
    }

    public Device getSmartCharger() {
        return smartCharger;
    }

    public void setSmartCharger(Device smartCharger) {
        this.smartCharger = smartCharger;
    }}
