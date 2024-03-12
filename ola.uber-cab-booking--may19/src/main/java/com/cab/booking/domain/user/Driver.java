package com.cab.booking.domain.user;

public class Driver extends User {
    public Driver() {
    }

    public Driver(String name) {
        super(name);
    }

    @Override
    public int hashCode() {
        return super.getName().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.getName().equals(((Driver)o).getName());
    }
}
