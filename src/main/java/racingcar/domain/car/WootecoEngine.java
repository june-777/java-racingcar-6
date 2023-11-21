package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class WootecoEngine implements Engine {
    private static final int MIN_POWER = 0;
    private static final int MAX_POWER = 9;

    @Override
    public int power() {
        return Randoms.pickNumberInRange(MIN_POWER, MAX_POWER);
    }
}
