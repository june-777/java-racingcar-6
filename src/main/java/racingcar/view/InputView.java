package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.view.reader.Reader;
import racingcar.view.validator.CarNameInputValidator;
import racingcar.view.validator.TotalRoundInputValidator;

public class InputView {

    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public List<String> readCarNames() {
        System.out.println(Message.CAR_NAME.message);
        String carNames = reader.readLine();
        CarNameInputValidator.validate(carNames);
        return Arrays.asList(carNames.split(","));
    }

    public int readTotalRound() {
        System.out.println(Message.TOTAL_ROUND.message);
        String totalRound = reader.readLine();
        TotalRoundInputValidator.validate(totalRound);
        return Integer.parseInt(totalRound);
    }

    private enum Message {
        CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

        TOTAL_ROUND("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
