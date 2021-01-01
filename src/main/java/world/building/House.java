package world.building;

import world.Character;
import world.exceptions.LeaveException;
import world.exceptions.EnterException;

public class House extends Building {
    public House(String name) {
        super(name);
    }

    @Override
    public void leave(Character character) throws LeaveException {
        String leaveMessage = getLeaveMessage(character) + "домик \""+name+"\"";
        if (inhabitants.contains(character)) {
            inhabitants.remove(character);
            System.out.println(leaveMessage);
            return;
        }
        throw new LeaveException(leaveMessage);
    }

    @Override
    public void enter(Character character) throws EnterException {
        String enterMessage = getEnterMessage(character) + "домик \""+name+"\"";
        if (!inhabitants.contains(character)) {
            inhabitants.add(character);
            System.out.println(enterMessage);
            return;
        }
        throw new EnterException(enterMessage);
    }

    @Override
    public String toString() {
        return "House{}";
    }
}
