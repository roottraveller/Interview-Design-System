package com.smartHome.domain.devices;

import com.smartHome.domain.State;
import java.util.Random;

public class Light implements Device {
    private long lightId;
    private State state;
    private int brightnessLevel;
    private final int MAX_BRIGHTNESS_LEVEL = 10;

    public Light() {
        this.lightId = new Random().nextInt();
        this.state = State.OFF;
        this.brightnessLevel = 0;
    }

    public long getLightId() {
        return lightId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    public void setBrightnessLevel(int brightnessLevel) {
        this.brightnessLevel = brightnessLevel;
    }

    public int getMaxBrightnessLevel() {
        return MAX_BRIGHTNESS_LEVEL;
    }
}
