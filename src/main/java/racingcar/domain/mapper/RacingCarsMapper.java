package racingcar.domain.mapper;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.RacingCars;

public class RacingCarsMapper {

    public RacingCars mapFrom(final List<String> carNamesInput) {
        List<Car> cars = createCars(carNamesInput);
        return new RacingCars(cars);
    }

    private List<Car> createCars(List<String> carNamesInput) {
        return carNamesInput.stream()
                .map(CarName::new)
                .map(carName -> new Car(carName, 0))
                .toList();
    }
}
