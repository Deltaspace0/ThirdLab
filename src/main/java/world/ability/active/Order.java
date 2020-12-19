package world.ability.active;

import world.GenderEnum;

public class Order implements ActiveAbility<String> {
    private GenderEnum gender;

    @Override
    public String run(String item) {
        String action;
        switch (gender) {
            case FEMALE:
                action = "распорядилась ";
                break;
            case MALE:
            default:
                action = "распорядился ";
        }
        return action + item;
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
