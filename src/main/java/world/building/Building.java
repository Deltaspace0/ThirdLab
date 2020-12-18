package world.building;

import world.Character;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Building {
    protected String name;
    protected List<Character> inhabitants = new ArrayList<>();

    public abstract void leave(Character c);
    public abstract void enter(Character c);

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Character> getInhabitants() {
        return inhabitants;
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
