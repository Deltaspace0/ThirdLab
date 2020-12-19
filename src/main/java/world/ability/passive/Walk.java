package world.ability.passive;

import world.GenderEnum;

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
            default:
                action = "шагал";
        }
        return action + " по улицам";
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
