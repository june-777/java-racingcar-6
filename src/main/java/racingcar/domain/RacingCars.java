package racingcar.domain;

import static racingcar.domain.exception.CarExceptionMessage.DUPLICATE_EXISTS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> uniqueCars = new HashSet<>(cars);

        if (cars.size() != uniqueCars.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXISTS.getMessage());
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
