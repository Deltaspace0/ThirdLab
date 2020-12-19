package world.ability.active;

import world.GenderEnum;

import java.util.Objects;

public class Fear implements ActiveAbility<String> {
    private GenderEnum gender;

    @Override
    public String toString() {
        return "Fear{" +
                "gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fear fear = (Fear) o;
        return gender == fear.gender;
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
                action = "боялась ";
                break;
            case MALE:
            default:
                action = "боялся ";
        }
        return "больше всего на свете " + action + item;
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
