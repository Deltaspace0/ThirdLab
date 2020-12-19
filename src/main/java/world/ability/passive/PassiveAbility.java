package world.ability.passive;

import world.GenderEnum;

public interface PassiveAbility {
    String run();
    void setGender(GenderEnum gender);
}
