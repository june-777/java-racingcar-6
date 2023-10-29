package racingcar;

import java.util.List;
import racingcar.view.Input;
import racingcar.view.View;

public class GameController {
    private final View view;
    private final Input input;

    public GameController(View view, Input input) {
        this.view = view;
        this.input = input;
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
}
