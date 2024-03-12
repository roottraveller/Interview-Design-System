package com.smartHome.domain.room;

import com.smartHome.domain.devices.Device;
import com.smartHome.domain.devices.Fan;
import com.smartHome.domain.devices.Light;

public class DrawingRoom implements Room {
    private Device light;
    private Device fan;

    public DrawingRoom() {
        this.light = null;
        this.fan = null;
    }

    public DrawingRoom(Light light) {
        this.light = light;
    }

    public DrawingRoom(Fan fan) {
        this.fan = fan;
    }


    public Device getLight() {
        return light;
    }

    public void setLight(Device light) {
        this.light = light;
    }

    public Device getFan() {
        return fan;
    }

    public void setFan(Device fan) {
        this.fan = fan;
    }

}
