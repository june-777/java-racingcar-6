package racingcar;

import racingcar.configuration.ApplicationConfiguration;
import racingcar.controller.FrontController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        FrontController frontController = applicationConfiguration.frontController();

        frontController.process();
    }
}
