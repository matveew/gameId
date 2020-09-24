package scanerio.lvl_1.lvl_2.lvl_3.lvl_4;

import database.WarriorDao;
import scanerio.Interaction;
import scanerio.Position;
import scanerio.lvl_1.lvl_2.LevelCheck;
import task.GetTask;
import warrior.Warrior;


import static telegram.Telegram.sendButtonsMessage;


public class Normal implements Interaction {

    private final int LEVEL = 4;

    GetTask getTask = new GetTask();

    WarriorDao warriorDao = new WarriorDao();

    Warrior warrior;

    LevelCheck checklvl = new LevelCheck();



    @Override
    public void play(Position position) {
        switch (position.getPositionByLevel(LEVEL)) {


            case "back":

                warrior = warriorDao.getWarrior(position.getId());

                warriorDao.saveNewWarrior(warrior);

                position.exit();
                position.action();

                break;


            default:

                warrior = warriorDao.getWarrior(position.getId());

                normal(position,3);

                break;
        }
    }

    private void checkAnswer(Position position, int expirience){

        String[] str;

        str = position.getPosition().split("easy\\.");

        if (str.length == 1)
            return;

        String rightAnswer = position.getPositionByLevel(3);

        String userAnswer = position.getPositionByLevel(4);

        if (userAnswer.equals(rightAnswer)) {

            sendButtonsMessage(position, "right");

            warrior.setExperience(expirience);

            position.goBack();
            position.goBack();

            return;


        } else {
            sendButtonsMessage(position, "wrong");

            position.goBack();
            position.goBack();

        }
    }


    private void normal(Position position, int expirience) {

        checklvl.checkLevel(warrior);

        warriorDao.saveNewWarrior(warrior);

        checkAnswer(position, expirience);

        sendButtonsMessage(position, getTask.getTaskLevel3());

        getTask.saveAnswer(position, getTask.toStringAnswer());
    }

}
