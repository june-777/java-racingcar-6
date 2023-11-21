package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.CarExceptionMessage;
import racingcar.domain.mapper.RacingCarsMapper;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.exception.InputExceptionMessage;

class RacingCarControllerTest {

    @DisplayName("Layer Exception Test")
    @Nested
    class LayerTest {

        @DisplayName("경주할 자동차 이름을 세팅할 때")
        @Nested
        class RacingCarSettingTest {

            @DisplayName("[Exception] 공백 입력이면 view에서 예외가 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"", " ", "  ", "\n", "\t", "\r"})
            void blankInput(String input) {
                InputView inputView = new InputView(() -> input);

                assertThatThrownBy(inputView::readCarNames)
                        .hasMessage(InputExceptionMessage.BLANK.getMessgae());
            }

            @DisplayName("[Exception] 양 끝에 쉼표가 존재하면 view에서 예외가 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {",pobi", "jun,", ",pobi,jun", "pobi,jun,"})
            void invalidCarNameFormInput(String input) {
                InputView inputView = new InputView(() -> input);

                assertThatThrownBy(inputView::readCarNames)
                        .hasMessage(InputExceptionMessage.INVALID_CAR_NAME_FORM.getMessgae());
            }

            @DisplayName("[Exception] 자동차 이름이 공백이면 domain에서 예외가 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"  ,pobi,jun", "pobi, ,jun", "pobi,jun,  ", "pobi,,jun"})
            void carNameBlank(String input) {
                InputView inputView = new InputView(() -> input);
                RacingCarService racingCarService = new RacingCarService(
                        new RacingCarsMapper());

                List<String> carNames = inputView.readCarNames();
                assertThatThrownBy(() -> racingCarService.createRacingCar(carNames))
                        .hasMessage(CarExceptionMessage.BLANK.getMessage());
            }

            @DisplayName("[Exception] 자동차 이름이 1 ~ 5길이가 아니면 domain에서 예외가 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"pobiii,jun"})
            void carNameExceedLength(String input) {
                InputView inputView = new InputView(() -> input);
                RacingCarService racingCarService = new RacingCarService(
                        new RacingCarsMapper());

                List<String> carNames = inputView.readCarNames();
                assertThatThrownBy(() -> racingCarService.createRacingCar(carNames))
                        .hasMessage(CarExceptionMessage.OUT_OF_LENGTH.getMessage());
            }

            @DisplayName("[Exception] 자동차 이름 서로 중복이면 domain에서 예외가 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"포비,준,포비"})
            void duplicateCarName(String input) {
                InputView inputView = new InputView(() -> input);
                RacingCarService racingCarService = new RacingCarService(
                        new RacingCarsMapper());

                List<String> carNames = inputView.readCarNames();
                assertThatThrownBy(() -> racingCarService.createRacingCar(carNames))
                        .hasMessage(CarExceptionMessage.DUPLICATE_EXISTS.getMessage());
            }

            @DisplayName("[Success] 정상 입력은 예외가 발생하지 않는다.")
            @ParameterizedTest
            @ValueSource(strings = {"pobi,jun", "p obi, jun", "  포!,준 ! ",
                    "    김, 준 ,    기"})
            void correct(String input) {
                InputView inputView = new InputView(() -> input);
                RacingCarService racingCarService = new RacingCarService(
                        new RacingCarsMapper());

                List<String> carNames = inputView.readCarNames();
                assertThatCode(() -> racingCarService.createRacingCar(carNames))
                        .doesNotThrowAnyException();
            }
        }
    }

}