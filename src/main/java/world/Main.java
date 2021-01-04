package world;

import java.util.ArrayList;
import java.util.List;

import world.ability.active.*;
import world.ability.passive.*;
import world.building.Building;
import world.building.BuildingEnum;
import world.exceptions.EnterException;
import world.exceptions.LeaveException;

public class Main {
    private static class MessageHandler {
        private static final List<String> names = new ArrayList<>();
        private static String singleMessage;
        private static String multipleMessage;

        public static void addMessage(String name, PassiveAbility ability) {
            GenderEnum originalGender = ability.getGender();
            ability.setGender(GenderEnum.MULTIPLE);
            String message = ability.run();
            ability.setGender(originalGender);
            if (names.isEmpty() || !message.equals(multipleMessage)) {
                connectAndPrint();
                singleMessage = ability.run();
                multipleMessage = message;
            }
            names.add(name);
        }

        public static <T> void addMessage(String name, ActiveAbility<T> ability, T item) {
            GenderEnum originalGender = ability.getGender();
            ability.setGender(GenderEnum.MULTIPLE);
            String message = ability.run(item);
            ability.setGender(originalGender);
            if (names.isEmpty() || !message.equals(multipleMessage)) {
                connectAndPrint();
                singleMessage = ability.run(item);
                multipleMessage = message;
            }
            names.add(name);
        }

        public static void connectAndPrint() {
            if (names.isEmpty())
                return;
            int namesCount = names.size();
            if (namesCount == 1) {
                System.out.println(names.get(0) + " " + singleMessage);
            } else {
                StringBuilder multipleName = new StringBuilder();
                for (int i = 0; i < namesCount-2; i++)
                    multipleName.append(names.get(i)).append(", ");
                multipleName.append(names.get(namesCount - 2)).append(" и ").append(names.get(namesCount - 1));
                System.out.println(multipleName + " " + multipleMessage);
            }
            names.clear();
        }
    }

    public static void main(String[] args) {
        class HandleableCharacter extends Character {
            public HandleableCharacter(Character character) {
                super(character.getName(), character.getGender());
            }

            @Override
            public void runAbility(PassiveAbility ability) {
                if (checkAbility(passiveAbilities, ability)) {
                    MessageHandler.addMessage(name, ability);
                }
            }

            @Override
            public <T> void runAbility(ActiveAbility<T> ability, T item) {
                if (checkAbility(activeAbilities, ability)) {
                    MessageHandler.addMessage(name, ability, item);
                }
            }
        }
        City greenCity = new City("Зелёный город");
        Building hospital1  = greenCity.createBuilding(BuildingEnum.HOSPITAL, "Больничка №1");
        Building houseM     = greenCity.createBuilding(BuildingEnum.HOUSE, ":D");

        Character cvetik    = new HandleableCharacter(greenCity.createCharacter(CharacterEnum.CVETIK));
        Character vintik    = new HandleableCharacter(greenCity.createCharacter(CharacterEnum.VINTIK));
        Character shpuntik  = new HandleableCharacter(greenCity.createCharacter(CharacterEnum.SHPUNTIK));
        Character medunica  = new HandleableCharacter(greenCity.createCharacter(CharacterEnum.MEDUNICA));
        Character malyshka  = new HandleableCharacter(greenCity.createCharacter(CharacterEnum.MALYSHKA));

        try {
            houseM.enter(malyshka);
            hospital1.enter(vintik);
            hospital1.enter(shpuntik);
        } catch (EnterException e) {
            System.err.println(e.getMessage());
        }

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
        shpuntik.runAbility(demand, "их сейчас же выписали");

        Fear fear = new Fear();
        fear.setGender(GenderEnum.FEMALE);
        medunica.addAbility(fear);
        medunica.runAbility(fear, "шума");

        Order order = new Order();
        order.setGender(GenderEnum.FEMALE);
        medunica.addAbility(order);
        medunica.runAbility(order, "поскорее выдать им одежду");

        Walk walk = new Walk();
        walk.setGender(GenderEnum.MALE);
        vintik.addAbility(walk);
        shpuntik.addAbility(walk);
        vintik.runAbility(walk);
        shpuntik.runAbility(walk);

        try {
            hospital1.leave(vintik);
            hospital1.leave(shpuntik);
        } catch (LeaveException e) {
            System.err.println(e.getMessage());
        }

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

        wakeUp.setGender(GenderEnum.FEMALE);
        malyshka.addAbility(wakeUp);
        malyshka.runAbility(wakeUp);

        ActiveAbility<String> lookout = new ActiveAbility<String>() {
            private GenderEnum gender;

            @Override
            public String run(String item) {
                return "стала выглядывать из " + item;
            }

            @Override
            public void setGender(GenderEnum gender) {
                this.gender = gender;
            }

            @Override
            public GenderEnum getGender() {
                return gender;
            }
        };
        malyshka.addAbility(lookout);
        malyshka.runAbility(lookout, "окна");

        PassiveAbility lope = new PassiveAbility() {
            private GenderEnum gender;

            @Override
            public String run() {
                return "бежала вприпрыжку сзади";
            }

            @Override
            public void setGender(GenderEnum gender) {
                this.gender = gender;
            }

            @Override
            public GenderEnum getGender() {
                return gender;
            }
        };
        malyshka.addAbility(lope);
        malyshka.runAbility(lope);

        try {
            houseM.leave(malyshka);
        } catch (LeaveException e) {
            System.err.println(e.getMessage());
        }

        MessageHandler.connectAndPrint();
    }
}
