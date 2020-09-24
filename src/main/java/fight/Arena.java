package fight;

import scanerio.Position;
import scanerio.lvl_1.lvl_2.lvl_3.lvl_4.FightAnversary;
import warrior.Warrior;
import database.WarriorDao;

import static telegram.Telegram.sendButtonsMessage;

public class Arena {

    int startHealt1;

    int startHealt2;

    WarriorDao warriorDao;

    Warrior warrior1;

    Warrior warrior2;

    public void deathBattle(Warrior warrior1, Warrior warrior2, Position position) {


        sendButtonsMessage(position, " ", warrior1.getName() + " " + warrior1.getLevel());
        System.out.println(warrior1.getName() + " " + warrior1.getLevel());

        sendButtonsMessage(position, " ", warrior2.getName() + " " + warrior2.getLevel());
        System.out.println(warrior2.getName() + " " + warrior2.getLevel());

        boolean isFight = true;

        startHealt1 = warrior1.getHealth();

        startHealt2 = warrior2.getHealth();

        while (isFight) {


            warrior2.getAttack(warrior1.attack());
            System.out.println(warrior2.getName() + " Health - " + warrior2.getHealth());
            sendButtonsMessage(position, " ", "warrior2.setHealth - " + warrior2.getHealth());

            if (warrior2.getHealth() <= 0) {
                System.out.println(warrior1.getName() + " won!");
                sendButtonsMessage(position, "findAdversary", "fightVsBot", warrior1.getName() + " won!");
                warrior1.setExperience(100);
                warrior1.setHealth(startHealt1);
                warrior2.setHealth(startHealt2);
                return;

            }

            warrior1.getAttack(warrior2.attack());

            System.out.println(warrior1.getName() + " Health - " + warrior1.getHealth());
            sendButtonsMessage(position, " ", "warrior1.setHealth - " + warrior1.getHealth());
            if (warrior1.getHealth() <= 0) {
                System.out.println(warrior2.getName() + " won!");
                sendButtonsMessage(position, "findAdversary", "fightVsBot", warrior2.getName() + " won!");
                warrior2.setExperience(100);
                warrior1.setHealth(startHealt1);
                warrior2.setHealth(startHealt2);
                return;
            }


        }


    }

    public void WarriorHit(Position positionWarrior1, Position positionWarrior2) {

        warrior1 = warriorDao.getWarrior(positionWarrior1.getId());

        warrior2 = warriorDao.getWarrior(positionWarrior2.getId());

        sendMessageTwoWarrior(positionWarrior1, positionWarrior2, "Hit");

        warrior2.getAttack(warrior1.attack());
        sendMessageTwoWarrior(positionWarrior1, positionWarrior2, warrior2.getName() + " Health: " + warrior2.getHealth());


        if (warrior2.getHealth() <= 0) {
            System.out.println(warrior1.getName() + " won!");
            sendMessageTwoWarrior(positionWarrior1, positionWarrior2, warrior1.getName() + " won");
            warrior1.setExperience(100);
            warrior1.setHealth(warrior1.getHealthFinal());
            warrior2.setHealth(warrior2.getHealthFinal());
            warriorDao.saveNewWarrior(warrior1);
            warriorDao.saveNewWarrior(warrior2);

            positionWarrior1.exit();
            positionWarrior2.exit();

            positionWarrior1.exitIdPositionWarriorAdversery();
            positionWarrior2.exitIdPositionWarriorAdversery();

            positionWarrior1.action();
            positionWarrior2.action();
            return;
        }

        warriorDao.saveNewWarrior(warrior1);
        warriorDao.saveNewWarrior(warrior2);

        new FightAnversary().continueBattle(positionWarrior1,positionWarrior2);

    }

    public void giveUp(Position positionWarrior1, Position positionWarrior2){

        warrior1 = warriorDao.getWarrior(positionWarrior1.getId());

        warrior2 = warriorDao.getWarrior(positionWarrior2.getId());

        System.out.println(warrior2.getName() + " won!");
        sendMessageTwoWarrior(positionWarrior1, positionWarrior2, warrior2.getName() + " won");
        warrior2.setExperience(100);
        warrior1.setHealth(warrior1.getHealthFinal());
        warrior2.setHealth(warrior2.getHealthFinal());
        warriorDao.saveNewWarrior(warrior1);
        warriorDao.saveNewWarrior(warrior2);

        positionWarrior1.exit();
        positionWarrior2.exit();

        positionWarrior1.exitIdPositionWarriorAdversery();
        positionWarrior2.exitIdPositionWarriorAdversery();

        positionWarrior1.action();
        positionWarrior2.action();

    }


    public void sendMessageTwoWarrior(Position positionWarrior1, Position positionWarrior2, String message) {

        sendButtonsMessage(positionWarrior1, message);
        sendButtonsMessage(positionWarrior2, message);
        System.out.println(message);

    }

}



