package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.RacingCars;

class RacingCarsTest {

    @DisplayName("자동차 경주를 시작하면")
    @Nested
    class DoRaceTest {
        @DisplayName("참여중인 모든 자동차는 각각 랜덤하게 전진한다")
        @Test
        void racingTest() {
            // given
            Car car1 = createCar("김준기", 7, 9, 4);
            Car car2 = createCar("포비", 1, 2, 4);
            Car car3 = createCar("King", 6, 5, 3);
            RacingCars racingCars = new RacingCars(Lists.newArrayList(car1, car2, car3));
            // when
            racingCars.startRace();
            racingCars.startRace();
            racingCars.startRace();
            // then
            assertThat(car1.isSamePosition(3)).isTrue();
            assertThat(car2.isSamePosition(1)).isTrue();
            assertThat(car3.isSamePosition(2)).isTrue();
        }

        private static Car createCar(String name, Integer... power) {
            List<Integer> powers = Lists.newArrayList(power);
            return new Car(new CarName(name),
                    () -> {
                        return powers.remove(0);
                    }
            );
        }
    }
}