package world.exceptions;

import world.City;
import world.building.BuildingEnum;

public class BuildingException extends RuntimeException {
    public BuildingException(City city, BuildingEnum building, String name) {
        super("В городе \"" + city.getName() + "\" появился неизвестный тип здания (" + building + "), которое называется \"" + name + "\"");
    }
}
