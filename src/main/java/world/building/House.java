package world.building;

import world.Character;

public class House extends Building {
    public House(String name) {
        super(name);
    }

    @Override
    public void leave(Character c) {
        String leaveMessage = getLeaveMessage(c) + "домик \""+name+"\"";
        if (inhabitants.contains(c)) {
            inhabitants.remove(c);
            System.out.println(leaveMessage);
            return;
        }
        System.out.println(leaveMessage);
    }

    @Override
    public void enter(Character c) {
        String enterMessage = getEnterMessage(c) + "домик \""+name+"\"";
        if (!inhabitants.contains(c)) {
            inhabitants.add(c);
            System.out.println(enterMessage);
            return;
        }
        System.out.println(enterMessage);
    }

    @Override
    public String toString() {
        return "House{}";
    }
}
