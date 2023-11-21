package racingcar.domain.mapper;

import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.WootecoEngine;

public class RacingCarsMapper {

    public RacingCars mapFrom(final List<String> carNamesInput) {
        List<Car> cars = toCars(carNamesInput);
        return new RacingCars(cars);
    }

    private List<Car> toCars(List<String> carNamesInput) {
        return carNamesInput.stream()
                .map(CarName::new)
                .map(carName -> new Car(carName, new WootecoEngine()))
                .toList();
    }
}
