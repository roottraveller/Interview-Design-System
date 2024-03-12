package com.smartHome.domain.devices;

import com.smartHome.domain.State;
import java.util.Random;

public class Fan implements Device {
    private long fanId;
    private State state;
    private int speed;
    private final int MAX_SPEED_LEVEL = 5;

    public Fan() {
        this.fanId = new Random().nextInt();
        this.state = State.OFF;
        this.speed = 0;
    }

    public long getFanId() {
        return fanId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxSpeedLevel() {
        return MAX_SPEED_LEVEL;
    }
}
