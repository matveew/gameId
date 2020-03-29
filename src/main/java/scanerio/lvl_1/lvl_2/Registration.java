package scanerio.lvl_1.lvl_2;

import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.lvl_3.Name;
import scanerio.lvl_1.lvl_2.lvl_3.Type;
import telegram.Telegram;

public class Registration implements Interaction {
    private final int LEVEL = 2;


    @Override
    public void play() {


        switch (Position.getPositionByLevel(LEVEL)) {
            case "type":
                type();
                break;


            case "name":
                name();


                break;

            default:
                Telegram.loadButtons("Save your type", "Back");
                break;
        }
    }

    private void type() {
        new Type().play();

    }

    private void name() {
        new Name().play();
    }

}
