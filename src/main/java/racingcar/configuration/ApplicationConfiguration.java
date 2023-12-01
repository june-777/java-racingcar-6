package racingcar.configuration;

import racingcar.controller.FrontController;
import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class ApplicationConfiguration {

    public FrontController frontController() {
        return new FrontController(racingCarController());
    }

    private RacingCarController racingCarController() {
        return new RacingCarController(inputView());
    }

    private InputView inputView() {
        return new InputView();
    }
}
