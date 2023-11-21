package racingcar.domain.exception;

public enum CarExceptionMessage {

    BLANK("[ERROR] 자동차 이름은 공백이여선 안됩니다."),
    CONTAIN_WRONG_ELEMENT("[ERROR] 자동차 이름에 쉼표가 포함되선 안됩니다."),
    OUT_OF_LENGTH("[ERROR] 자동차 이름은 1 ~ 5글자여야 합니다."),
    DUPLICATE_EXISTS("[ERROR] 자동차 이름은 서로 중복일 수 없습니다."),
    OUT_OF_TOTAL_COUNT("[ERROR] 자동차의 개수가 정해진 범위를 벗어났습니다.");

    private final String message;

    CarExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
