package world.ability.passive;

import world.GenderEnum;

public class WakeUp implements PassiveAbility {
    private GenderEnum gender;

    @Override
    public String run() {
        switch (gender) {
            case FEMALE:
                return "проснулась";
            case MALE:
            default:
                return "проснулся";
        }
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
