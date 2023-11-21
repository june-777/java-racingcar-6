package racingcar.domain.car;

import static racingcar.domain.exception.CarExceptionMessage.DUPLICATE_EXISTS;
import static racingcar.domain.exception.CarExceptionMessage.OUT_OF_TOTAL_COUNT;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Map<String, Integer> getCars() {
        Map<String, Integer> nameAndPosition = convertToNameAndPosition(cars);
        return Collections.unmodifiableMap(nameAndPosition);
    }

    private Map<String, Integer> convertToNameAndPosition(List<Car> target) {
        Map<String, Integer> nameAndPosition = new LinkedHashMap<>();
        for (Car car : target) {
            nameAndPosition.put(car.getName().getName(), car.getPosition());
        }
        return nameAndPosition;
    }

    public List<String> calculateWinnerCars() {
        int maxPosition = findMaxPosition();
        List<Car> maxPositionCars = findMaxPositionCars(maxPosition);

        return maxPositionCars.stream()
                .map(car -> car.getName().getName())
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> findMaxPositionCars(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
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
