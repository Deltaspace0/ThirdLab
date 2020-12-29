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
        composeSong.setGender(GenderEnum.MALE);
        cvetik.addAbility(composeSong);
        cvetik.runAbility(composeSong, "о зарядке");
        Song chargeSong = composeSong.getSong();
        chargeSong.setContent("Начинай с зарядки день, Разгоняй движеньем лень.");

        WakeUp wakeUp = new WakeUp();
        wakeUp.setGender(GenderEnum.MALE);
        vintik.addAbility(wakeUp);
        shpuntik.addAbility(wakeUp);
        vintik.runAbility(wakeUp);
        shpuntik.runAbility(wakeUp);

        Demand demand = new Demand();
        demand.setGender(GenderEnum.MALE);
        vintik.addAbility(demand);
        shpuntik.addAbility(demand);
        vintik.runAbility(demand, "их сейчас же выписали");
        shpuntik.runAbility(demand, "их немедленно выписали");

        Fear fear = new Fear();
        fear.setGender(GenderEnum.FEMALE);
        medunica.addAbility(fear);
        medunica.runAbility(fear, "шума");

        Order order = new Order();
        order.setGender(GenderEnum.FEMALE);
        medunica.addAbility(order);
        medunica.runAbility(order, "поскорее выдать им одежду");
        hospital1.leave(vintik);
        hospital1.leave(shpuntik);

        Walk walk = new Walk();
        walk.setGender(GenderEnum.MALE);
        vintik.addAbility(walk);
        shpuntik.addAbility(walk);
        vintik.runAbility(walk);
        shpuntik.runAbility(walk);

        Sing sing = new Sing();
        sing.setGender(GenderEnum.MALE);
        vintik.addAbility(sing);
        shpuntik.addAbility(sing);
        vintik.runAbility(sing, chargeSong);
        shpuntik.runAbility(sing, chargeSong);

        Charge charge = new Charge();
        charge.setGender(GenderEnum.MALE);
        vintik.addAbility(charge);
        shpuntik.addAbility(charge);
        vintik.runAbility(charge);
        shpuntik.runAbility(charge);
    }
}
