package world.building;

import world.Character;

public class House extends Building {
    public House(String name) {
        super(name);
    }

    @Override
    public void leave(Character c) {
        if (!inhabitants.contains(c)) {
            String action;
            switch (c.getGender()) {
                case FEMALE:
                    action = "была ";
                    break;
                case MALE:
                default:
                    action = "был ";
            }
            System.out.println("Там не " + action + c.getName() + ", он не может покинуть домик");
            return;
        }
        inhabitants.remove(c);
        System.out.println(c.getName() + " покинул домик \""+name+"\"");
    }

    @Override
    public void enter(Character c) {
        inhabitants.add(c);
        System.out.println(c.getName() + " пришёл в домик\""+name+"\"");
    }

    @Override
    public String toString() {
        return "House{}";
    }
}
