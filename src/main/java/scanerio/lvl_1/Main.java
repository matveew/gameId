package scanerio.lvl_1;

import database.PositionDao;
import database.UserDao;
import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.Experience;
import scanerio.lvl_1.lvl_2.Fight;
import scanerio.lvl_1.lvl_2.Registration;
import telegram.Telegram;


public class Main implements Interaction {
    private final int LEVEL = 1;

    public void play(Position position) {
        System.out.println(position.getPositionByLevel(LEVEL));

        switch (position.getPositionByLevel(LEVEL)) {
            case "fight":
                fight(position);
                break;

            case "experience":
                experience(position);
                break;

            case "registration":
                registration(position);
                break;


            default:
                deleteWrongPosition(position,LEVEL);
                Telegram.sendButtonsMessage(position, "fight", "experience", "Choose an option:");
                PositionDao.setPosition(position);
                break;
        }


    }


    void fight(Position position) {
        new Fight().play(position);

    }

    void experience(Position position) {

        new Experience().play(position);
    }

    void registration(Position position) {

        if (position.getPosition().equals("registration")) {
            position.goAhead("type");
        }

        new Registration().play(position);
    }

    private void deleteWrongPosition(Position position,int lvl){
        String[] str = position.getPosition().split("\\.");
        if (str.length >= lvl)
            position.exit();
    }

}
