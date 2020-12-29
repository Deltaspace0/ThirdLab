package world.ability.passive;

import world.GenderEnum;

import java.util.Objects;

public class Walk implements PassiveAbility {
    private GenderEnum gender;

    @Override
    public String run() {
        String action;
        switch (gender) {
            case FEMALE:
                action = "шагала";
                break;
            case MALE:
                action = "шагал";
                break;
            default:
                action = "шагали";
        }
        return action + " по улицам";
    }

    @Override
    public String toString() {
        return "Walk{" +
                "gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Walk walk = (Walk) o;
        return gender == walk.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
