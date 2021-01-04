package world.ability.active;

import world.GenderEnum;

import java.util.Objects;

public class Demand implements ActiveAbility<String> {
    private GenderEnum gender;

    @Override
    public String toString() {
        return "Demand{" +
                "gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demand demand = (Demand) o;
        return gender == demand.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
    }

    @Override
    public String run(String item) {
        String action;
        switch (gender) {
            case FEMALE:
                action = "стала";
                break;
            case MALE:
                action = "стал";
                break;
            default:
                action = "стали";
        }
        return action + " требовать, чтобы " + item;
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    @Override
    public GenderEnum getGender() {
        return gender;
    }
}
