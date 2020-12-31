package world.building;

import world.Character;

public class Hospital extends Building {
    public Hospital(String name) {
        super(name);
    }

    @Override
    public void leave(Character c) {
        String leaveMessage = getLeaveMessage(c) + "больничку \""+name+"\"";
        if (inhabitants.contains(c)) {
            inhabitants.remove(c);
            System.out.println(leaveMessage);
            return;
        }
        System.out.println(leaveMessage);
    }

    @Override
    public void enter(Character c) {
        String enterMessage = getEnterMessage(c) + "больничку \""+name+"\"";
        if (!inhabitants.contains(c)) {
            inhabitants.add(c);
            System.out.println(enterMessage);
            return;
        }
        System.out.println(enterMessage);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                '}';
    }
}
