package racingcar.controller;

public class FrontController {

    private final RacingCarController racingCarController;

    public FrontController(RacingCarController racingCarController) {
        this.racingCarController = racingCarController;
    }

    public void process() {
        try {
            racingCarController.process();
        } catch (IllegalArgumentException e) {
            // 예외 출력에 대한 명시는 없음
            // 해당 미션은 예외에 대한 핸들링이 존재하지 않으므로, 사실 FrontController로 분리하지 않아도 됨
//            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
