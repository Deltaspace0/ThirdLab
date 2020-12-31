package world.exceptions;

import world.City;
import world.TimeEnum;

public class TimeException extends RuntimeException {
    public TimeException(City city, TimeEnum time) {
        super("В городе \"" + city.getName() + "\" наступило неизвестное время суток: " + time);
    }
}
