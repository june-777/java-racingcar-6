package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.view.Input;
import racingcar.view.View;

public class GameController {
    private final View view;
    private final Input input;

    public GameController(View view, Input input) {
        this.view = view;
        this.input = input;
    }

    public void run() {
        final RacingCars racingCars = readyToCarRace();
        long attemptCounts = chooseAttemptCounts();
        view.printPlayResultText();
        playCarRace(attemptCounts, racingCars);
        List<String> winnerNames = calculateFinalWinners(racingCars);
        view.printFinalWinners(winnerNames);
    }

    private RacingCars readyToCarRace() {
        view.printGameStartMessage();
        String carNamesInput = input.inputCarNames();
        Validator.validate(carNamesInput);
        List<String> carNames = GameUtil.splitByCommas(carNamesInput);
        return new RacingCars(carNames);
    }

    private long chooseAttemptCounts() {
        view.printAttemptCountsQuestionMessage();
        return input.inputAttemptCounts();
    }

    private void playCarRace(long attemptCounts, RacingCars cars) {
        for (int attempCount = 0; attempCount < attemptCounts; attempCount++) {
            List<Car> endCars = cars.doRace();
            deliverToViewAboutOneGameResult(endCars);
        }
    }

    private void deliverToViewAboutOneGameResult(List<Car> endCars) {
        List<String> names = mappingToNames(endCars);
        List<Long> moveCounts = mappingToMoveCounts(endCars);
        view.printResult(names, moveCounts);
    }

    private List<String> calculateFinalWinners(RacingCars racingCars) {
        List<Car> winners = racingCars.findWinners();
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        return winnerNames;
    }

}
