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
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
