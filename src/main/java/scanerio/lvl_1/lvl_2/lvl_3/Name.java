package scanerio.lvl_1.lvl_2.lvl_3;


import createWarrior.Create;
import global.GlobalWarrior;
import scanerio.Interaction;
import scanerio.Position;
import sun.plugin2.message.Message;
import telegram.Telegram;

public class Name implements Interaction {
    private final int LEVEL = 3;

    @Override
    public void play() {
        GlobalWarrior.getWarrior().setName(Position.getPositionByLevel(LEVEL));
        Telegram.sendMessage("You created " + GlobalWarrior.getWarrior().getType() + " - " + GlobalWarrior.getWarrior().getName());
        Position.exit();
        Position.action();
    }
}
