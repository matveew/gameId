package scanerio.lvl_1.lvl_2.lvl_3;

import createWarrior.Create;
import database.PositionDao;
import database.WarriorDao;
import scanerio.Position;
import scanerio.Interaction;
import telegram.Telegram;
import warrior.Warrior;

public class Type implements Interaction {
    private final int LEVEL = 3;

    @Override
    public void play(Position position) {


        if (!position.getPositionByLevel(LEVEL).isEmpty()) {
            Warrior warrior = Create.newWarrior(position.getPositionByLevel(LEVEL));
            warrior.setId(position.getId());
            WarriorDao.saveNewWarrior(warrior);
            position.goBack(); // form wizard
            position.goBack(); //  from type
            position.goAhead("name");
            PositionDao.setPosition(position);
            position.action();


        } else {
            Telegram.sendButtonsMessage(position, "wizard", "robber", "exit", "Choose an option:");
        }

    }
}
