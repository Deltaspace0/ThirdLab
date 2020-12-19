package world.ability.active;

import world.GenderEnum;

public interface ActiveAbility<T> {
    String run(T item);
    void setGender(GenderEnum gender);
}
