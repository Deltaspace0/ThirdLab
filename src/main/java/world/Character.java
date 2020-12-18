package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import world.ability.passive.PassiveAbility;
import world.ability.active.ActiveAbility;

public class Character {
    private String name;
    private GenderEnum gender;
    private List<PassiveAbility> passiveAbilities = new ArrayList<>();
    private List<ActiveAbility> activeAbilities = new ArrayList<>();

    public Character(String name, GenderEnum gender) {
        this.name = name;
        this.gender = gender;
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

    public GenderEnum getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", passiveAbilities=" + passiveAbilities +
                ", activeAbilities=" + activeAbilities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) && gender == character.gender && Objects.equals(passiveAbilities, character.passiveAbilities) && Objects.equals(activeAbilities, character.activeAbilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, passiveAbilities, activeAbilities);
    }
}