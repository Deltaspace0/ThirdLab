package world.ability.active;

public class Demand implements ActiveAbility<String> {
    @Override
    public String run(String item) {
        return "стал требовать, чтобы " + item;
    }
}
