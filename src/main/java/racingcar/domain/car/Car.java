package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private static final int MOVABLE_MIN_CONDITION = 4;
    private final CarName name;
    private final Engine engine;
    private int position;

    public Car(CarName name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public void move() {
        if (isMovable(engine.power())) {
            position++;
        }
    }

    private boolean isMovable(int power) {
        return MOVABLE_MIN_CONDITION <= power;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "(" + name + "," + position + ")";
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
