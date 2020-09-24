import database.PositionDao;
import database.WarriorDao;
import scanerio.Position;
import scanerio.lvl_1.Main;

import static telegram.Telegram.sendButtonsMessage;

public class Test {

    private void checkAnswer(Position position, int expirience) {
        String[] str;

        str = position.getPosition().split("easy\\.");

        if (str.length == 1)
            return;

        str = str[1].split("\\.");

        if (str.length > 1) {

            String rightAnswer = str[0];

            String userAnswer = str[1];

            if (userAnswer.equals(rightAnswer)) {

                sendButtonsMessage(position, "right");



                position.goBack();
                position.goBack();

                return;
            } else {
                sendButtonsMessage(position, "wrong");

                position.goBack();
                position.goBack();

            }
        }
    }

    public static void main(String[] args) {

        new Main().play(PositionDao.getPosition(160450965));

    }
}
