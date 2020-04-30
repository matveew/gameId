package scanerio.lvl_1.lvl_2.lvl_3;


import database.PositionDao;
import database.WarriorDao;
import scanerio.Interaction;
import scanerio.Position;
import telegram.Telegram;
import warrior.Warrior;

public class Name implements Interaction {
    private final int LEVEL = 3;

    @Override
    public void play(Position position) {


        if (!position.getPositionByLevel(LEVEL).isEmpty()) {

            Warrior warrior = WarriorDao.getWarrior(position.getId());
            warrior.setName(position.getPositionByLevel(LEVEL));
            WarriorDao.saveNewWarrior(warrior);
            Telegram.sendButtonsMessage(position, "You created " + warrior.getType() + " - " + warrior.getName());
            position.exit();
            PositionDao.setPosition(position);
            position.action();


        } else {
            Telegram.sendButtonsMessage(position, "exit", "Write name:");
        }


    }
}
