package racingcar.configuration;

import racingcar.controller.RacingCarController;
import racingcar.domain.mapper.RacingCarsMapper;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.reader.ConsoleReader;
import racingcar.view.reader.Reader;

public class ApplicationConfiguration {

    public RacingCarController racingCarController() {
        return new RacingCarController(inputView(), outputView(), racingCarService());
    }

    private InputView inputView() {
        return new InputView(consoleReader());
    }

    private Reader consoleReader() {
        return new ConsoleReader();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private RacingCarService racingCarService() {
        return new RacingCarService(racingCarsMapper());
    }

    private RacingCarsMapper racingCarsMapper() {
        return new RacingCarsMapper();
    }
}
