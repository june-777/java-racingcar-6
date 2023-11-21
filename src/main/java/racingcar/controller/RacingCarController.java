package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        RacingCars racingCars = settingRacingCars();
        //TODO:
    }

    private RacingCars settingRacingCars() {
        List<String> carNames = inputView.readCarNames();
        return racingCarService.createRacingCar(carNames);
    }
}
