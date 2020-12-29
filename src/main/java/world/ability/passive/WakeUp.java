package world.ability.passive;

import world.GenderEnum;

import java.util.Objects;

public class WakeUp implements PassiveAbility {
    private GenderEnum gender;

    @Override
    public String toString() {
        return "WakeUp{" +
                "gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WakeUp wakeUp = (WakeUp) o;
        return gender == wakeUp.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
    }

    @Override
    public String run() {
        switch (gender) {
            case FEMALE:
                return "проснулась";
            case MALE:
                return "проснулся";
            default:
                return "проснулись";
        }
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
