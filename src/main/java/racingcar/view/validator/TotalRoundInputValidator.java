package racingcar.view.validator;

public class TotalRoundInputValidator {

    public static void validate(String target) {
        validateBlank(target);
        validateNumeric(target);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
