package world;

import world.ability.active.*;
import world.ability.passive.*;

public class Main {
    public static void main(String[] args) {
        City greenCity = new City("Зелёный город");
        greenCity.setTime(TimeEnum.MORNING);

        Character cvetik   = greenCity.createCharacter(CharacterEnum.CVETIK);
        Character vintik   = greenCity.createCharacter(CharacterEnum.VINTIK);
        Character shpuntik = greenCity.createCharacter(CharacterEnum.SHPUNTIK);
        Character medunica = greenCity.createCharacter(CharacterEnum.MEDUNICA);

        Compose composeSong = new Compose();
        cvetik.getActiveAbilities().add(composeSong);
        cvetik.runAbility(composeSong, "о зарядке");
        Song chargeSong = composeSong.getSong();

        WakeUp wakeUp = new WakeUp();
        vintik.getPassiveAbilities().add(wakeUp);
        shpuntik.getPassiveAbilities().add(wakeUp);
        vintik.runAbility(wakeUp);
        shpuntik.runAbility(wakeUp);

        Demand demand = new Demand();
        vintik.getActiveAbilities().add(demand);
        shpuntik.getActiveAbilities().add(demand);
        vintik.runAbility(demand, "их сейчас же выписали");
        shpuntik.runAbility(demand, "их немедленно выписали");

        Fear fear = new Fear();
        medunica.getActiveAbilities().add(fear);
        medunica.runAbility(fear, "шума");

        Order order = new Order();
        medunica.getActiveAbilities().add(order);
        medunica.runAbility(order, " поскорее выдать им одежду");

        Walk walk = new Walk();
        vintik.getPassiveAbilities().add(walk);
        shpuntik.getPassiveAbilities().add(walk);
        vintik.runAbility(walk);
        shpuntik.runAbility(walk);

        Sing sing = new Sing();
        vintik.getActiveAbilities().add(sing);
        shpuntik.getActiveAbilities().add(sing);
        vintik.runAbility(sing, chargeSong);
        shpuntik.runAbility(sing, chargeSong);

        Charge charge = new Charge();
        vintik.getPassiveAbilities().add(charge);
        shpuntik.getPassiveAbilities().add(charge);
        vintik.runAbility(charge);
        shpuntik.runAbility(charge);
    }
}
