package racingcar.controller;

import java.util.List;
import java.util.Map;
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
        int totalRound = settingTotalRound();
        processTotalRoundRace(racingCars, totalRound);
        renderingFinalWinner(racingCars);
    }

    private RacingCars settingRacingCars() {
        List<String> carNames = inputView.readCarNames();
        return racingCarService.createRacingCar(carNames);
    }

    private int settingTotalRound() {
        return inputView.readTotalRound();
    }

    private void processTotalRoundRace(RacingCars racingCars, int totalRound) {
        outputView.printPlayResultMessage();
        for (int round = 1; round <= totalRound; round++) {
            racingCars.startRace();
            Map<String, Integer> cars = racingCars.getCars();
            outputView.printOneRoundResult(cars);
        }
    }

    private void renderingFinalWinner(RacingCars racingCars) {
        List<String> winnerCars = racingCars.calculateWinnerCars();
        outputView.printWinner(winnerCars);
    }
}
