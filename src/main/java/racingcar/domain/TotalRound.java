package racingcar.domain;

public class TotalRound {
    private final int round;

    public TotalRound(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round <= 0 || round >= 100) {
            throw new IllegalArgumentException("잘못된 횟수의 라운드입니다.");
        }
    }
}
