package scanerio.lvl_1;

import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.Registration;
import telegram.Telegram;

public class Main implements Interaction {
    private final int LEVEL = 1;

    public void play() {


        switch (Position.getPositionByLevel(LEVEL)) {
            case "fight":
                fight();
                break;

            case "experience":
                experience();
                break;

            case "registration":
                registration();
                break;


            default:
                Telegram.loadButtons("fight", "experience");
                break;
        }


    }


    void fight() {

    }

    void experience() {
    }

    void registration() {
        new Registration().play();
    }


}
