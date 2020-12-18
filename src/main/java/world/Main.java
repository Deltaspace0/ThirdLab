package world;

import world.ability.active.*;
import world.ability.passive.*;
import world.building.Building;
import world.building.BuildingEnum;

public class Main {
    public static void main(String[] args) {
        City greenCity = new City("Зелёный город");
        Building hospital1  = greenCity.createBuilding(BuildingEnum.HOSPITAL, "Больничка №1");

        Character cvetik    = greenCity.createCharacter(CharacterEnum.CVETIK);
        Character vintik    = greenCity.createCharacter(CharacterEnum.VINTIK);
        Character shpuntik  = greenCity.createCharacter(CharacterEnum.SHPUNTIK);
        Character medunica  = greenCity.createCharacter(CharacterEnum.MEDUNICA);

        hospital1.enter(vintik);
        hospital1.enter(shpuntik);

        greenCity.setTime(TimeEnum.MORNING);

        Compose composeSong = new Compose();
        cvetik.addAbility(composeSong);
        cvetik.runAbility(composeSong, "о зарядке");
        Song chargeSong = composeSong.getSong();

        WakeUp wakeUp = new WakeUp();
        vintik.addAbility(wakeUp);
        shpuntik.addAbility(wakeUp);
        vintik.runAbility(wakeUp);
        shpuntik.runAbility(wakeUp);

        Demand demand = new Demand();
        vintik.addAbility(demand);
        shpuntik.addAbility(demand);
        vintik.runAbility(demand, "их сейчас же выписали");
        shpuntik.runAbility(demand, "их немедленно выписали");

        Fear fear = new Fear();
        medunica.addAbility(fear);
        medunica.runAbility(fear, "шума");

        Order order = new Order();
        medunica.addAbility(order);
        medunica.runAbility(order, "поскорее выдать им одежду");
        hospital1.leave(vintik);
        hospital1.leave(shpuntik);

        Walk walk = new Walk();
        vintik.addAbility(walk);
        shpuntik.addAbility(walk);
        vintik.runAbility(walk);
        shpuntik.runAbility(walk);

        Sing sing = new Sing();
        vintik.addAbility(sing);
        shpuntik.addAbility(sing);
        vintik.runAbility(sing, chargeSong);
        shpuntik.runAbility(sing, chargeSong);

        Charge charge = new Charge();
        vintik.addAbility(charge);
        shpuntik.addAbility(charge);
        vintik.runAbility(charge);
        shpuntik.runAbility(charge);
    }
}
