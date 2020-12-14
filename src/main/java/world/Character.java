package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import world.ability.passive.PassiveAbility;
import world.ability.active.ActiveAbility;

public class Character {
    private String name;
    private List<PassiveAbility> passiveAbilities = new ArrayList<>();
    private List<ActiveAbility> activeAbilities = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public List<PassiveAbility> getPassiveAbilities() {
        return passiveAbilities;
    }

    public List<ActiveAbility> getActiveAbilities() {
        return activeAbilities;
    }

    public void runAbility(PassiveAbility ability) {
        if (checkAbility(passiveAbilities, ability)) {
            System.out.println(name + " " + ability.run());
        }
    }

    public <T> void runAbility(ActiveAbility<T> ability, T item) {
        if (checkAbility(activeAbilities, ability)) {
            System.out.println(name + " " + ability.run(item));
        }
    }

    private <A> boolean checkAbility(List<A> abilities, A ability) {
        boolean abilityExists = abilities.contains(ability);
        if (!abilityExists)
            System.out.println(name + " не может использовать способность " + ability);
        return abilityExists;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Character {name = \"" + name + "\"}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passiveAbilities, activeAbilities);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Character)) return false;
        Character c = (Character) obj;
        return name.equals(c.name) &&
                passiveAbilities.equals(c.getPassiveAbilities()) &&
                activeAbilities.equals(c.getActiveAbilities());
    }
}