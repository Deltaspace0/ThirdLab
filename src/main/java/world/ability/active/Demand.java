package world.ability.active;

public class Demand implements ActiveAbility<String> {
    @Override
    public String run(String item) {
        return "стал требовать, чтобы " + item;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
