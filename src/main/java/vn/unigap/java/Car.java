package vn.unigap.java;

import java.util.Objects;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return (int) (Math.random() * 5000);
    }
//
//    @Override
//    public int hashCode() {
////        if (name == null) return 43;
////        return name.hashCode();
//        return 1;
//    }
}
