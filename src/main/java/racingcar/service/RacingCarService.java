package racingcar.service;

import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.mapper.RacingCarsMapper;

public class RacingCarService {

    private final RacingCarsMapper racingCarsMapper;

    public RacingCarService(RacingCarsMapper racingCarsMapper) {
        this.racingCarsMapper = racingCarsMapper;
    }

    public RacingCars createRacingCar(final List<String> carNamesInput) {
        return racingCarsMapper.mapFrom(carNamesInput);
    }
}
