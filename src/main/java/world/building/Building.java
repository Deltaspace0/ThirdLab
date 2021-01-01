package world.building;

import world.Character;
import world.GenderEnum;
import world.exceptions.LeaveException;
import world.exceptions.EnterException;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Building {
    protected String name;
    protected List<Character> inhabitants = new ArrayList<>();

    protected String getLeaveMessage(Character character) {
        if (!inhabitants.contains(character)) {
            if (character.getGender() == GenderEnum.FEMALE)
                return "Там не была " + character.getName() + ", она не может покинуть ";
            if (character.getGender() == GenderEnum.MALE)
                return "Там не был " + character.getName() + ", он не может покинуть ";
            return "Там не были " + character.getName() + ", они не могут покинуть ";
        }
        if (character.getGender() == GenderEnum.FEMALE)
            return character.getName() + " покинула ";
        if (character.getGender() == GenderEnum.MALE)
            return character.getName() + " покинул ";
        return character.getName() + " покинули ";
    }

    protected String getEnterMessage(Character character) {
        if (inhabitants.contains(character)) {
            if (character.getGender() == GenderEnum.FEMALE)
                return "Там уже есть " + character.getName() + ", она не может прийти в ";
            if (character.getGender() == GenderEnum.MALE)
                return "Там уже есть " + character.getName() + ", он не может прийти в ";
            return "Там уже есть " + character.getName() + ", они не могут прийти в ";
        }
        if (character.getGender() == GenderEnum.FEMALE)
            return character.getName() + " пришла в ";
        if (character.getGender() == GenderEnum.MALE)
            return character.getName() + " пришёл в ";
        return character.getName() + " пришли в ";
    }

    public abstract void leave(Character character) throws LeaveException;
    public abstract void enter(Character character) throws EnterException;

    public Building(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(name, building.name) && Objects.equals(inhabitants, building.inhabitants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inhabitants);
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", inhabitants=" + inhabitants +
                '}';
    }

}
