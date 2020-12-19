package world.ability.active;

import world.GenderEnum;

public class Demand implements ActiveAbility<String> {
    private GenderEnum gender;

    @Override
    public String run(String item) {
        String action;
        switch (gender) {
            case FEMALE:
                action = "стала";
                break;
            case MALE:
            default:
                action = "стал";
        }
        return action + " требовать, чтобы " + item;
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
