package world.ability.active;

import world.Song;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Compose{" +
                "song=" + song +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compose compose = (Compose) o;
        return Objects.equals(song, compose.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(song);
    }

}
