package com.smartHome.domain.devices;

import com.smartHome.domain.State;
import java.util.Random;

public class SmartCharger implements Device {
    private long smartChargerId;
    private State state;

    public SmartCharger() {
        this.smartChargerId = new Random().nextInt();
        this.state = State.OFF;
    }

    public long getSmartChargerId() {
        return smartChargerId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
