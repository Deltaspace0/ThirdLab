package world.ability.active;

public class Fear implements ActiveAbility<String> {
    @Override
    public String run(String item) {
        return "больше всего на свете боялась " + item;
    }
}
