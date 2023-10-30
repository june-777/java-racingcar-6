package racingcar.controller;

import java.util.List;
import racingcar.dto.OneGameResultsDto;
import racingcar.service.RacingGameService;
import racingcar.service.domain.RacingCars;
import racingcar.service.domain.WootecoEngine;
import racingcar.utils.GameUtil;
import racingcar.view.InputView;
import racingcar.view.View;

public class GameController {
    private final View view;
    private final InputView inputView;

    private final RacingGameService racingGameService;

    public GameController(View view, InputView inputView, RacingGameService racingGameService) {
        this.view = view;
        this.inputView = inputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        final RacingCars racingCars = readyToCarRace();
        int attemptCounts = chooseAttemptCounts();
        view.printPlayResultText();
        playCarRace(attemptCounts, racingCars);
        List<String> winnerNames = racingGameService.calculateFinalWinners(racingCars);
        view.printFinalWinners(winnerNames);
    }

    private RacingCars readyToCarRace() {
        view.printGameStartMessage();
        String carNamesInput = inputView.inputCarNames();
        List<String> carNames = GameUtil.splitByCommas(carNamesInput);
        return new RacingCars(carNames, new WootecoEngine());   // TODO: 컨트롤러에서 엔진을 설정하는게 마음에 안듦
    }

    private int chooseAttemptCounts() {
        view.printAttemptCountsQuestionMessage();
        return inputView.inputAttemptCounts();
    }

    private void playCarRace(int attemptCounts, RacingCars cars) {
        for (int attempCount = 0; attempCount < attemptCounts; attempCount++) {
            OneGameResultsDto resultDto = racingGameService.playOneTimeCarRace(cars);
            deliverToViewAboutOneGameResult(resultDto);
        }
    }

    private void deliverToViewAboutOneGameResult(OneGameResultsDto resultDto) {
        view.printResult(resultDto);
    }

}
