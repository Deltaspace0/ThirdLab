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
