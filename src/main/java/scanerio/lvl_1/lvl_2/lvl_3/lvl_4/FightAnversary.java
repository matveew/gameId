package scanerio.lvl_1.lvl_2.lvl_3.lvl_4;


import database.PositionDao;
import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.lvl_3.GoToFight;
import warrior.Warrior;
import database.WarriorDao;
import fight.Arena;

import static telegram.Telegram.sendButtonsMessage;

public class FightAnversary implements Interaction {

    final int LEVEL = 4;

    String stringPositionGoToFight = "fight.fightAdversary.GoToFight";

    String stringPositionWait = "fight.fightAdversary.Wait";

    Warrior warrior;

    Warrior warriorAdversary;

    Position positionWarriorAdversary;

    Arena arena = new Arena();

    WarriorDao warriorDao = new WarriorDao();

    PositionDao positionDao;


    @Override
    public void play(Position position) {

        positionWarriorAdversary = positionDao.getPosition(position.getIdPositionWarriorAdversery());

        switch (position.getPositionByLevel(LEVEL)) {

            case "Hit":

                arena.WarriorHit(position, positionWarriorAdversary);



                PositionDao.setPosition(position);

                PositionDao.setPosition(positionWarriorAdversary);



                break;


            case "Give up":

                arena.giveUp(position, positionWarriorAdversary);

                break;

            default:
                position.deleteWrongPosition(position,stringPositionGoToFight);
                sendButtonsMessage(position,  "Hit", "Give up", "Choose an option:");
                PositionDao.setPosition(position);
                break;


        }
    }

    void goToFight(Position position) {

        new GoToFight().play(position);

    }

    public void continueBattle(Position position, Position positionWarriorAdversary){
        position.setPosition(stringPositionWait);

        positionWarriorAdversary.setPosition(stringPositionGoToFight);

        goToFight(positionWarriorAdversary);
    }
}

