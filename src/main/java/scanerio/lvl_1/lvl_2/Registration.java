package scanerio.lvl_1.lvl_2;

import database.PositionDao;
import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.lvl_3.Name;
import scanerio.lvl_1.lvl_2.lvl_3.Type;
import telegram.Telegram;

public class Registration implements Interaction {
    private final int LEVEL = 2;


    @Override
    public void play(Position position) {


        switch (position.getPositionByLevel(LEVEL)) {
            case "type":
                type(position);
                break;


            case "name":
                name(position);
                break;

            default:

                Telegram.sendButtonsMessage(position, "Save your type", "Back", "Choose an option:");
                PositionDao.setPosition(position);
                break;
        }
    }

    private void type(Position position) {
        new Type().play(position);

    }

    private void name(Position position) {
        new Name().play(position);
    }

}
