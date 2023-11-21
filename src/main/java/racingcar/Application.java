package racingcar;

import racingcar.configuration.ApplicationConfiguration;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        RacingCarController racingCarController = applicationConfiguration.racingCarController();
        racingCarController.run();
    }
}
