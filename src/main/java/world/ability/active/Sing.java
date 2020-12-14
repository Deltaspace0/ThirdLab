package world.ability.active;

import world.Song;

public class Sing implements ActiveAbility<Song> {
    @Override
    public String run(Song song) {
        return "распевал песенку " + song.getName();
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
