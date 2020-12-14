package world.building;

import world.Character;

public class House extends Building {
    public House(String name) {
        super(name);
    }

    @Override
    public void leave(Character c) {
        if (!inhabitants.contains(c)) {
            System.out.println("Там не был " + c.getName() + ", он не может покинуть домик");
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
}
