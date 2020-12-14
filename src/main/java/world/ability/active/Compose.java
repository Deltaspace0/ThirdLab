package world.ability.active;

import world.Song;

public class Compose implements ActiveAbility<String> {
    private Song song;

    @Override
    public String run(String item) {
        song = new Song(item);
        return "сочинил песенку " + item;
    }

    public Song getSong() {
        return song;
    }
}
