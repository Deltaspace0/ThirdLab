package world.ability.active;

import world.GenderEnum;
import world.Song;

public class Sing implements ActiveAbility<Song> {
    private GenderEnum gender;

    @Override
    public String run(Song song) {
        String action;
        switch (gender) {
            case FEMALE:
                action = "распевала";
                break;
            case MALE:
            default:
                action = "распевал";
        }
        return action + " песенку " + song.getName();
    }

    @Override
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
