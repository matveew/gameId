package scanerio.lvl_1.lvl_2;

import javafx.geometry.Pos;
import scanerio.Interaction;
import scanerio.Position;

public class Task implements Interaction {
    final int LEVEL = 2;

    @Override
    public void play(Position position) {
        switch (position.getPositionByLevel(LEVEL)) {
            case "findAdversary":
                break;

            case "fight":
                break;


            default:
                // loadButtons("fight", "experience");
                // svaPosition

                break;
        }


    }
}
