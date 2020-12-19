package world.building;

import world.Character;

public class Hospital extends Building {
    public Hospital(String name) {
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
            System.out.println("Там не " + action + c.getName() + ", он не может покинуть больничку");
            return;
        }
        inhabitants.remove(c);
        System.out.println(c.getName() + " покинул больничку \""+name+"\"");
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void enter(Character c) {
        inhabitants.add(c);
        System.out.println(c.getName() + " пришёл в больничку \""+name+"\"");
    }
}
