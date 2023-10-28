package racingcar;

public class Car {

    public final String name;
    private final Engine engine;
    private long totalMoveCount;

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

    private boolean canMove(int power) {
        return power >= 4;
    }

    private int startEngine() {
        return engine.generateRandomNumber();
    }

    public long getTotalMoveCount() {
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
