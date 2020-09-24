package scanerio.lvl_1.lvl_2;

import database.PositionDao;
import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.lvl_3.lvl_4.Easy;
import scanerio.lvl_1.lvl_2.lvl_3.lvl_4.Normal;



import static telegram.Telegram.sendButtonsMessage;


public class Experience implements Interaction {

    private final int LEVEL = 2;

    String stringPosition = "experience";


    @Override
    public void play(Position position) {
        switch (position.getPositionByLevel(LEVEL)) {
            case "easy":

                easy(position);

                break;

            case "normal":

                noraml(position);

                break;

            case "back":

                position.exit();
                position.action();

                break;

            default:
                position.deleteWrongPosition(position,stringPosition);
                sendButtonsMessage(position, "back","easy", "normal", "Choose an option:");
                PositionDao.setPosition(position);
                break;
        }
    }


    void easy(Position position) {
        new Easy().play(position);
    }

    void noraml(Position position){
        new Normal().play(position);
    }


}
