package scanerio.lvl_1;

import database.PositionDao;
import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.Registration;
import telegram.Telegram;

public class Main implements Interaction {
    private final int LEVEL = 1;

    public void play(Position position) {
        System.out.println(position.getPositionByLevel(LEVEL));

        switch (position.getPositionByLevel(LEVEL)) {
            case "fight":
                fight();
                break;

            case "experience":
                experience();
                break;

            case "registration":
                registration(position);
                break;


            default:

                Telegram.sendButtonsMessage(position, "fight", "experience", "Choose an option:");
                PositionDao.setPosition(position);
                break;
        }


    }


    void fight() {

    }

    void experience() {
    }

    void registration(Position position) {

        if (position.getPosition().equals("registration")) {
            position.goAhead("type");
        }

        new Registration().play(position);
    }


}
