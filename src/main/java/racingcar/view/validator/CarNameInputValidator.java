package racingcar.view.validator;

import static racingcar.view.exception.InputExceptionMessage.BLANK;

public class CarNameInputValidator {

    public static void validate(String target) {
        validateBlank(target);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(BLANK.getMessgae());
        }
    }
}
