package world.ability.active;

import world.GenderEnum;

import java.util.Objects;

public class Order implements ActiveAbility<String> {
    private GenderEnum gender;

    @Override
    public String toString() {
        return "Order{" +
                "gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return gender == order.gender;
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
                action = "распорядилась ";
                break;
            case MALE:
                action = "распорядился ";
                break;
            default:
                action = "распорядились ";
        }
        return action + item;
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
