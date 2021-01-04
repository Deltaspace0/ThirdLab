package world.ability.passive;

import world.GenderEnum;

import java.util.Objects;

public class Charge implements PassiveAbility {
    private GenderEnum gender;

    @Override
    public String run() {
        String action;
        switch (gender) {
            case FEMALE:
                action = "делала";
                break;
            case MALE:
                action = "делал";
                break;
            default:
                action = "делали";
        }
        return action + " зарядку";
    }

    @Override
    public String toString() {
        return "Charge{" +
                "gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return gender == charge.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
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
