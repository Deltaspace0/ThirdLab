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
    public String toString() {
        return "Building {name = \"" + name +
                "\", inhabitants = " + inhabitants + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inhabitants);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof  Building))
            return false;
        Building b = (Building) obj;
        return name.equals(b.getName()) && inhabitants.equals(b.getInhabitants());
    }
}
