package world.building;

import world.Character;

public class Hospital extends Building {
    public Hospital(String name) {
        super(name);
    }

    @Override
    public void leave(Character c) {
        if (!inhabitants.contains(c)) {
            System.out.println("Там не был " + c.getName() + ", он не может покинуть больничку");
            return;
        }
        inhabitants.remove(c);
        System.out.println(c.getName() + " покинул больничку \""+name+"\"");
    }

    @Override
    public void enter(Character c) {
        inhabitants.add(c);
        System.out.println(c.getName() + " пришёл в больничку \""+name+"\"");
    }
}
