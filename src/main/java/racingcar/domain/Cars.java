package racingcar.domain;

import java.util.HashSet;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    public void validateDuplicate(List<Car> cars) {
        HashSet<Car> uniqueCars = new HashSet<>(cars);

        if (uniqueCars.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 이름이 자동차가 존재합니다.");
        }
    }
}
