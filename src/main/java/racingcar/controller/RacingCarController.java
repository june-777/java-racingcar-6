package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TotalRound;
import racingcar.view.InputView;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void process() {
        Cars cars = initCars();
        TotalRound totalRound = initTotalRound();
    }

    private Cars initCars() {
        List<String> carsInput = inputView.readCars();
        List<Car> cars = toCars(carsInput);
        return new Cars(cars);
    }

    private List<Car> toCars(List<String> carsInput) {
        return carsInput.stream()
                .map(Car::new)
                .toList();
    }

    private TotalRound initTotalRound() {
        int totalRoundInput = inputView.readTotalRound();
        return new TotalRound(totalRoundInput);
    }
}
