package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPlayResultMessage() {
        System.out.println(Message.PLAY_RESULT.message);
    }

    public void printOneRoundResult(Map<String, Integer> oneRoundResponse) {
        for (String name : oneRoundResponse.keySet()) {
            int position = oneRoundResponse.get(name);

            System.out.printf(Message.ONE_ROUND_RESULT.message,
                    name,
                    Message.POSITION_SIGN.message.repeat(position)
            );
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerNames) {
        String winnerResultForm = String.join(", ", winnerNames);
        System.out.printf(Message.WINNER.message, winnerResultForm);
    }

    private enum Message {
        PLAY_RESULT("\n실행 결과"),
        ONE_ROUND_RESULT("%s : %s\n"),
        POSITION_SIGN("-"),
        WINNER("최종 우승자 : %s");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
