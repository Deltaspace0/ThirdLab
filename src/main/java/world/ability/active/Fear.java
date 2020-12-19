package world.ability.active;

import world.GenderEnum;

public class Fear implements ActiveAbility<String> {
    private GenderEnum gender;

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
