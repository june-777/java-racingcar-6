package racingcar.domain;

public class Car {
    private final CarName name;
    private final int position;

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }
}
