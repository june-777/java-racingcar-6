package racingcar.domain;

import static racingcar.domain.exception.CarExceptionMessage.DUPLICATE_EXISTS;
import static racingcar.domain.exception.CarExceptionMessage.OUT_OF_TOTAL_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.car.Car;

public class RacingCars {
    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_COUNT = 500;
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateDuplicate(cars);
        validateTotalCount(cars);
        this.cars = cars;
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> uniqueCars = new HashSet<>(cars);

        if (cars.size() != uniqueCars.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXISTS.getMessage());
        }
    }

    private void validateTotalCount(List<Car> cars) {
        if (cars.size() < MIN_CAR_COUNT || cars.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(OUT_OF_TOTAL_COUNT.getMessage());
        }
    }

    public void startRace() {
        for (Car car : cars) {
            car.move();
        }
    }

    public boolean contains(Car car) {
        return cars.contains(car);
    }

    @Override
    public String toString() {
        return "RacingCars" +
                cars;
    }
}
