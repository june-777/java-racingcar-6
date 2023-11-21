package racingcar.domain.car;

import static racingcar.domain.exception.CarExceptionMessage.BLANK;
import static racingcar.domain.exception.CarExceptionMessage.CONTAIN_WRONG_ELEMENT;
import static racingcar.domain.exception.CarExceptionMessage.OUT_OF_LENGTH;

import java.util.Objects;

public class CarName {
    private static final String WRONG_ELEMENT = ",";
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateWrongExists(name);
        validateLength(name);
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

    private void validateLength(String name) {
        if (name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_LENGTH.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
