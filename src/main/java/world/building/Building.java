package world.building;

import world.Character;
import world.GenderEnum;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Building {
    protected String name;
    protected List<Character> inhabitants = new ArrayList<>();

    protected String getLeaveMessage(Character c) {
        if (!inhabitants.contains(c)) {
            if (c.getGender() == GenderEnum.FEMALE)
                return "Там не была " + c.getName() + ", она не может покинуть ";
            if (c.getGender() == GenderEnum.MALE)
                return "Там не был " + c.getName() + ", он не может покинуть ";
            return "Там не были " + c.getName() + ", они не могут покинуть ";
        }
        if (c.getGender() == GenderEnum.FEMALE)
            return c.getName() + " покинула ";
        if (c.getGender() == GenderEnum.MALE)
            return c.getName() + " покинул ";
        return c.getName() + " покинули ";
    }

    protected String getEnterMessage(Character c) {
        if (inhabitants.contains(c)) {
            if (c.getGender() == GenderEnum.FEMALE)
                return "Там уже есть " + c.getName() + ", она не может прийти в ";
            if (c.getGender() == GenderEnum.MALE)
                return "Там уже есть " + c.getName() + ", он не может прийти в ";
            return "Там уже есть " + c.getName() + ", они не могут прийти в ";
        }
        if (c.getGender() == GenderEnum.FEMALE)
            return c.getName() + " пришла в ";
        if (c.getGender() == GenderEnum.MALE)
            return c.getName() + " пришёл в ";
        return c.getName() + " пришли в ";
    }

    public abstract void leave(Character c);
    public abstract void enter(Character c);

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
