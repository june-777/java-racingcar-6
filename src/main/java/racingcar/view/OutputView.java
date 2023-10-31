package racingcar.view;

import java.util.List;
import racingcar.dto.OneGameResultsDto;
import racingcar.dto.ResultDto;

public class OutputView {
    private static final String HYPHEN = "-";
    private static final String RESULT_FORM = "%s : %s%n";
    private static final String FINAL_WINNER_FORM = "최종 우승자 : %s";

    public void printPlayResultText() {
        System.out.println("\n실행 결과");
    }

    public void printResult(OneGameResultsDto resultDto) {
        for (ResultDto result : resultDto.getResults()) {
            System.out.printf(RESULT_FORM, result.getName(), HYPHEN.repeat(result.getPosition()));
        }
        System.out.println();
    }

    public void printFinalWinners(List<String> winners) {
        System.out.printf(FINAL_WINNER_FORM, String.join(", ", winners));
    }
}
