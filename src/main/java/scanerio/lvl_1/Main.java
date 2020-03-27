package scanerio.lvl_1;

import scanerio.Interaction;
import scanerio.Position;

public class Main implements Interaction {
    int level = 1;

    public void play() {



        switch (Position.getPositionByLevel(level)) {
            case "fight":
                fight();
                break;
            case "experience":
                experience();
                break;
            default:
                loadButtons("fight", "experience");
                break;
        }


    }


    void fight() {


    }

    void experience() {
    }


    void loadButtons(String... buttons) {

    }

}
