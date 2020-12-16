package world;

import world.building.Building;
import world.building.BuildingEnum;
import world.building.Hospital;
import world.building.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private String name;
    private TimeEnum time;
    private List<Character> characters = new ArrayList<>();
    private List<Building> buildings = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public List<Building> getBuildings() {
        return buildings;
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

    @Override
    public String toString() {
        return "City {name = \"" + name + "\"}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, characters, buildings);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City c = (City) obj;
        return name.equals(c.getName()) &&
                characters.equals(c.getCharacters()) &&
                buildings.equals(c.getBuildings());
    }
}
