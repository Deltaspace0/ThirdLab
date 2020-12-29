package world.ability.active;

import world.GenderEnum;
import world.Song;

import java.util.Objects;

public class Compose implements ActiveAbility<String> {
    private Song song;
    private GenderEnum gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compose compose = (Compose) o;
        return Objects.equals(song, compose.song) && gender == compose.gender;
    }

    @Override
    public String toString() {
        return "Compose{" +
                "song=" + song +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(song, gender);
    }

    @Override
    public String run(String item) {
        song = new Song(item);
        String action;
        switch (gender) {
            case FEMALE:
                action = "сочинила";
                break;
            case MALE:
                action = "сочинил";
                break;
            default:
                action = "сочинили";
        }
        return action + " песенку " + item;
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Song getSong() {
        return song;
    }

}
