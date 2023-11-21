package racingcar.domain.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.RacingCars;

class RacingCarsMapperTest {

    @DisplayName("올바른 자동차 이름이 주어졌을 때")
    @Nested
    class CorrectCarNames {

        RacingCarsMapper racingCarsMapper = new RacingCarsMapper();

        @DisplayName("경주용 자동차에 해당 자동차가 포함되는지 확인한다.")
        @ParameterizedTest
        @CsvSource(value = {"pobi,jun,주운"})
        void contain(String name1, String name2, String name3) {
            // given
            List<String> carNames = Arrays.asList(name1, name2, name3);
            Car car1 = new Car(new CarName(name1), 0);
            Car car2 = new Car(new CarName(name2), 0);
            Car car3 = new Car(new CarName(name3), 0);

            // when
            RacingCars racingCars = racingCarsMapper.mapFrom(carNames);

            // then
            assertThat(racingCars.contains(car1)).isTrue();
            assertThat(racingCars.contains(car2)).isTrue();
            assertThat(racingCars.contains(car3)).isTrue();
        }
    }

}