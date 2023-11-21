package racingcar.view.validator;

import static racingcar.view.exception.InputExceptionMessage.BLANK;
import static racingcar.view.exception.InputExceptionMessage.INVALID_CAR_NAME_FORM;

public class CarNameInputValidator {

    private static final char SEPERATOR = ',';

    public static void validate(String target) {
        validateBlank(target);
        validateCarNameInputForm(target);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(BLANK.getMessgae());
        }
    }

    private static void validateCarNameInputForm(String target) {
        if (isFirstCharacterIsSeperator(target) || isLastCharacterIsSeperator(target)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_FORM.getMessgae());
        }
    }

    private static boolean isFirstCharacterIsSeperator(String target) {
        return target.charAt(0) == SEPERATOR;
    }

    private static boolean isLastCharacterIsSeperator(String target) {
        return target.charAt(target.length() - 1) == SEPERATOR;
    }
}
