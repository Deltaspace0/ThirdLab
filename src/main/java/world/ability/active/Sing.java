package world.ability.active;

import world.Song;

public class Sing implements ActiveAbility<Song> {
    @Override
    public String run(Song song) {
        return "распевал песенку " + song.getName();
    }
}
