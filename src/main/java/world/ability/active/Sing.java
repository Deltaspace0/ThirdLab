package world.ability.active;

import world.GenderEnum;
import world.Song;

import java.util.Objects;

public class Sing implements ActiveAbility<Song> {
    private GenderEnum gender;

    @Override
    public String toString() {
        return "Sing{" +
                "gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sing sing = (Sing) o;
        return gender == sing.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
    }

    @Override
    public String run(Song song) {
        String action;
        switch (gender) {
            case FEMALE:
                action = "распевала";
                break;
            case MALE:
                action = "распевал";
                break;
            default:
                action = "распевали";
        }
        return action + " песенку " + song.getName() + ": \"" + song.getContent() + "\"";
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    @Override
    public GenderEnum getGender() {
        return gender;
    }
}
