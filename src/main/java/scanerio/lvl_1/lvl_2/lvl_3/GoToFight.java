package scanerio.lvl_1.lvl_2.lvl_3;

import database.PositionDao;
import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.lvl_3.lvl_4.FightAnversary;


import static telegram.Telegram.sendButtonsMessage;

public class GoToFight implements Interaction {

    final int LEVEL = 3;

    String stringPositionWait = "fight.fightAdversary.Wait";


    @Override
    public void play(Position position) {
        switch (position.getPositionByLevel(LEVEL)) {

            case "GoToFight":

                fightAdversary(position);

                break;

            case "Wait":
                position.deleteWrongPosition(position, stringPositionWait);
                sendButtonsMessage(position, "Wait");
                System.out.println(position.getPosition());
                PositionDao.setPosition(position);
                break;


            default:
                position.deleteWrongPosition(position, stringPositionWait);
                sendButtonsMessage(position, "Wait");
                PositionDao.setPosition(position);

                break;

        }
    }

    void fightAdversary(Position position) {
        new FightAnversary().play(position);
    }


}
