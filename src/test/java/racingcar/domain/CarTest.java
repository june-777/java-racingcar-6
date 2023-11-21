package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;

class CarTest {

    @DisplayName("자동차가 움직이려고 할 때")
    @Nested
    class MoveTest {

        @DisplayName("엔진 출력이 4 미만이면 움직이지 않는다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        void cantMove(int power) {
            // given
            Car car = new Car(
                    new CarName("준기"),
                    () -> power
            );
            int expectedPosition = 0;
            // when
            car.move();
            // then
            assertThat(car.isSamePosition(expectedPosition)).isTrue();
        }

        @DisplayName("엔진 출력이 4 이상이면 움직인다.")
        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        void canMove(int power) {
            // given
            Car car = new Car(
                    new CarName("준기"),
                    () -> power
            );
            int expectedPosition = 1;
            // when
            car.move();
            // then
            assertThat(car.isSamePosition(expectedPosition)).isTrue();
        }
    }

}