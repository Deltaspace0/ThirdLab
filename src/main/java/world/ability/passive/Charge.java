package world.ability.passive;

import world.GenderEnum;

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
            default:
                action = "делал";
        }
        return action + " зарядку";
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
