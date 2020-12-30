package world;

import world.building.Building;
import world.building.BuildingEnum;
import world.building.Hospital;
import world.building.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private final String name;
    private TimeEnum time;
    protected List<Character> characters = new ArrayList<>();
    protected List<Building> buildings = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void setTime(TimeEnum time) {
        this.time = time;
        switch (time) {
            case MORNING:
                System.out.println("Пришло утро в " + name);
                break;
            case NOON:
                System.out.println("Пришёл день в " + name);
                break;
            case EVENING:
                System.out.println("Пришёл вечер в " + name);
                break;
            case NIGHT:
                System.out.println("Пришла ночь в " + name);
                break;
            default:
                System.out.println("Что-то странное пришло в " + name);
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", characters=" + characters +
                ", buildings=" + buildings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && time == city.time && Objects.equals(characters, city.characters) && Objects.equals(buildings, city.buildings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, time, characters, buildings);
    }

    public Character createCharacter(CharacterEnum c) {
        Character newCharacter;
        switch (c) {
            case CVETIK:
                newCharacter = new Character("Цветик", GenderEnum.MALE);
                break;
            case VINTIK:
                newCharacter = new Character("Винтик", GenderEnum.MALE);
                break;
            case SHPUNTIK:
                newCharacter = new Character("Шпунтик", GenderEnum.MALE);
                break;
            case MEDUNICA:
                newCharacter = new Character("Медуница", GenderEnum.FEMALE);
                break;
            case MALYSHKA:
                newCharacter = new Character("Малышка", GenderEnum.FEMALE);
                break;
            default:
                System.out.println("Что-то странное только что попыталось появиться");
                return null;
        }
        characters.add(newCharacter);
        return newCharacter;
    }

    public Building createBuilding(BuildingEnum b, String name) {
        Building newBuilding;
        switch (b) {
            case HOSPITAL:
                newBuilding = new Hospital(name);
                break;
            case HOUSE:
                newBuilding = new House(name);
                break;
            default:
                System.out.println("Да таких зданий не существует!");
                return null;
        }
        buildings.add(newBuilding);
        return newBuilding;
    }
}
