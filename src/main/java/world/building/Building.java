package world.building;

import world.Character;
import java.util.List;
import java.util.ArrayList;

public abstract class Building {
    protected String name;
    protected List<Character> inhabitants = new ArrayList<>();

    public abstract void leave(Character c);
    public abstract void enter(Character c);

    public Building(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Character> getInhabitants() {
        return inhabitants;
    }
}
