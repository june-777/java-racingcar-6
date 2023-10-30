package racingcar.service.domain;

public class Car {

    public final String name;
    private final Engine engine;
    private int totalMoveCount;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public void moveCar() {
        int power = startEngine();
        if (canMove(power)) {
            this.totalMoveCount++;
        }
    }

    private int startEngine() {
        return engine.generateNumber();
    }

    private boolean canMove(int power) {
        return power >= 4;
    }

    public int getTotalMoveCount() {
        return totalMoveCount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", totalMoveCount=" + totalMoveCount +
                '}';
    }
}
