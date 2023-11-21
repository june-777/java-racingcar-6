package racingcar.view.validator;

import racingcar.view.exception.InputExceptionMessage;

public class TotalRoundInputValidator {

    public static void validate(String target) {
        validateBlank(target);
        validateNumeric(target);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(InputExceptionMessage.BLANK.getMessgae());
        }
    }

    private static void validateNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionMessage.NOT_NUMERIC.getMessgae(), e);
        }
    }
}
