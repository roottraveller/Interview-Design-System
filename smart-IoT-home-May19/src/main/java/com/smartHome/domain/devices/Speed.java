package com.smartHome.domain.devices;

public enum Speed {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int speed;

    Speed(int speed) {
        this.speed = speed;
    }

    public Speed getSpeed(int speed) {
        Speed speed2 = null;
        for (Speed speed1 : Speed.values()) {
            speed2 = speed1.getSpeed(speed);
        }
        return speed2;
    }
}
