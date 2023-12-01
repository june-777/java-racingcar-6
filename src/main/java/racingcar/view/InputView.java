package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    Pattern pattern = Pattern.compile("([가-힣\\s]+)");

    public List<String> readCars() {
        System.out.println(Message.CARS.message);
        String cars = Console.readLine();
        validateBlank(cars);
        return List.of(cars.split(","));
    }

    public int readTotalRound() {
        System.out.println(Message.TOTAL_ROUND.message);
        String totalRound = Console.readLine();
        validateBlank(totalRound);
        return Integer.parseInt(totalRound);
    }

    private void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException("공백 입력은 안됩니다.");
        }
    }

    private enum Message {
        CARS("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        TOTAL_ROUND("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
