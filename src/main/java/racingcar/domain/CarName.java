package racingcar.domain;

import static racingcar.domain.exception.CarNameExceptionMessage.BLANK;
import static racingcar.domain.exception.CarNameExceptionMessage.CONTAIN_WRONG_ELEMENT;

public class CarName {
    private static final String WRONG_ELEMENT = ",";
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateWrongExists(name);
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(BLANK.getMessage());
        }
    }

    private void validateWrongExists(String name) {
        if (name.contains(WRONG_ELEMENT)) {
            throw new IllegalArgumentException(CONTAIN_WRONG_ELEMENT.getMessage());
        }
    }
}
