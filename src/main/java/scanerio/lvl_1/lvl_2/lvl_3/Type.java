package scanerio.lvl_1.lvl_2.lvl_3;

import createWarrior.Create;
import global.GlobalWarrior;
import scanerio.Position;
import scanerio.Interaction;
import telegram.Telegram;

public class Type implements Interaction {
    private final int LEVEL = 3;

    @Override
    public void play() {
        GlobalWarrior.setWarrior(Create.newWarrior(Position.getPositionByLevel(LEVEL)));
        Telegram.loadButtons("Set name", "exit");
        Position.goBack();
        Position.goAhead("name");
        Position.action();
    }


}
