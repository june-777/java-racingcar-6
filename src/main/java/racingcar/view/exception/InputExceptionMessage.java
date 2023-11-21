package racingcar.view.exception;

public enum InputExceptionMessage {
    BLANK("[ERROR] 공백 입력은 안됩니다."),
    INVALID_CAR_NAME_FORM("[ERROR] 입력 양 끝에 쉼표가 들어가선 안됩니다."),
    NOT_NUMERIC("[ERROR] 숫자만 입력해야 합니다.");

    private final String messgae;

    InputExceptionMessage(String messgae) {
        this.messgae = messgae;
    }

    public String getMessgae() {
        return messgae;
    }
}
