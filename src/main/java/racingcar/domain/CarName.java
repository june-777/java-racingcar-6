package racingcar.domain;

import static racingcar.domain.exception.CarNameExceptionMessage.BLANK;

public class CarName {
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateBlank(name);
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(BLANK.getMessage());
        }
    }
}
