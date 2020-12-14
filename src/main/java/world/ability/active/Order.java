package world.ability.active;

public class Order implements ActiveAbility<String> {
    @Override
    public String run(String item) {
        return "распорядилась " + item;
    }
}
