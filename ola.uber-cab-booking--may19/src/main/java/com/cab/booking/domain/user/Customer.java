package com.cab.booking.domain.user;

public class Customer extends User {
    public Customer() {
    }

    public Customer(String name) {
        super(name);
    }

    @Override
    public int hashCode() {
        return super.getName().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.getName().equals(((Customer)o).getName());
    }
}
