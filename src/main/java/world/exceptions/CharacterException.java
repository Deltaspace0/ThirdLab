package world.exceptions;

import world.City;
import world.CharacterEnum;

public class CharacterException extends RuntimeException {
    public CharacterException(City city, CharacterEnum character) {
        super("В городе \"" + city.getName() + "\" появился неизвестный персонаж: " + character);
    }
}
