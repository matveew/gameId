package scanerio.lvl_1.lvl_2;

import database.PositionDao;
import scanerio.Interaction;
import scanerio.Position;
import warrior.Warrior;
import database.WarriorDao;
import fight.Arena;
import scanerio.lvl_1.lvl_2.lvl_3.GoToFight;

import static telegram.Telegram.sendButtonsMessage;

public class Fight implements Interaction {
    final int LEVEL = 2;

    LevelCheck checklvl = new LevelCheck();

    String stringPositionFight = "fight";

    String stringPositionFind = "fight.findAdversary";

    String stringPositionWait = "fight.fightAdversary.Wait";

    String stringPositionGoToFight = "fight.fightAdversary.GoToFight";

    Warrior warrior;

    Warrior warriorBot;

    Warrior warriorAdversary;

    Position positionWarriorAdversary;

    Arena arena = new Arena();

    WarriorDao warriorDao = new WarriorDao();

    PositionDao positionDao;

    String stringIdPositionWarriorAdversary;

    @Override
    public void play(Position position) {

        warrior = warriorDao.getWarrior(position.getId());
        switch (position.getPositionByLevel(LEVEL)) {

            case "fightAdversary":

                if(position.getIdPositionWarriorAdversery() == 0) {
                    position.deleteWrongPosition(position, stringPositionFight);
                    sendButtonsMessage(position, "back", "findAdversary", "fightVsBot", "Choose an option:");
                    PositionDao.setPosition(position);
                    break;
                }

                goToFight(position);

                break;



            case "findAdversary":

                switch (position.getPositionByLevel(3))
                {
                    case "back":

                        position.deleteWrongPosition(position, stringPositionFight);
                        sendButtonsMessage(position, "back", "findAdversary", "fightVsBot", "Choose an option:");
                        PositionDao.setPosition(position);

                        return;

                }

                position.deleteWrongPosition(position, stringPositionFind);

                positionWarriorAdversary = warriorDao.getPositionWarriorAdversary(position);

                if(positionWarriorAdversary.getPosition().isEmpty()) {
                    sendButtonsMessage(position, "Search Adversary");
                    position.deleteWrongPosition(position, stringPositionFind);
                    break;
                }

                position.setIdPositionWarriorAdversery(positionWarriorAdversary.getId());

                positionWarriorAdversary.setIdPositionWarriorAdversery(position.getId());

                warriorAdversary = warriorDao.getWarrior(positionWarriorAdversary.getId());

                arena.sendMessageTwoWarrior(position,positionWarriorAdversary,warrior.getName() + " VS " + warriorAdversary.getName());

                position.setPosition(stringPositionGoToFight);

                positionWarriorAdversary.setPosition(stringPositionWait);

                positionDao.setPosition(position);

                positionDao.setPosition(positionWarriorAdversary);

                goToFight(position);

                break;

            case "fightVsBot":

                warriorBot = getWarriorBot(warrior);

                arena.deathBattle(warrior,warriorBot,position);

                checklvl.checkLevel(warrior);

                warriorDao.saveNewWarrior(warrior);

                position.goBack();

                break;

            case "back":
                position.exit();
                position.action();
                break;


            default:
                position.deleteWrongPosition(position, stringPositionFight);
                sendButtonsMessage(position,"back", "findAdversary", "fightVsBot", "Choose an option:");
                PositionDao.setPosition(position);
                break;
        }
    }


    public void setPositionWarriorAdversary(Position position){
        positionWarriorAdversary = position;
    }

    void goToFight(Position position){

        new GoToFight().play(position);

    }

    private int getRandomHealth(int health) {

        if (Math.random() < 0.1)
            return health + health / 10;
        if (Math.random() < 0.3)
            return health + health / 20;
        if (Math.random() < 0.6)
            return health;
        if (Math.random() < 0.9)
            return health - health / 20;
        else
            return health - health / 10;
    }

    private int getRandomArmor(int armor) {
        if (Math.random() < 0.1)
            return armor + armor / 5;
        if (Math.random() < 0.3)
            return armor + armor / 10;
        if (Math.random() < 0.6)
            return armor;
        if (Math.random() < 0.9)
            return armor - armor / 10;
        else
            return armor - armor / 5;
    }

    private int getRandomdamageMax(int damageMax) {
        if (Math.random() < 0.1)
            return damageMax + damageMax / 5;
        if (Math.random() < 0.3)
            return damageMax + damageMax / 10;
        if (Math.random() < 0.6)
            return damageMax;
        if (Math.random() < 0.9)
            return damageMax - damageMax / 10;
        else
            return damageMax - damageMax / 5;

    }

    private int getRandomDamageMin(int damageMin) {
        if (Math.random() < 0.1)
            return damageMin + damageMin / 5;
        if (Math.random() < 0.3)
            return damageMin + damageMin / 10;
        if (Math.random() < 0.6)
            return damageMin;
        if (Math.random() < 0.9)
            return damageMin - damageMin / 10;
        else
            return damageMin - damageMin / 5;
    }

    private int getRandomLevel(int level) {
        if (Math.random() < 0.1)
            return level + 2;
        if (Math.random() < 0.3)
            return level + 1;
        if (Math.random() < 0.6)
            return level;
        if (Math.random() < 0.9)
            return level - 1;
        else
            return level - 2;

    }

    private int ValidationInt(int i){
        if(i <= 0)
            i = 0;
        return i;
    }


    private Warrior getWarriorBot(Warrior warrior) {

        Warrior warriorBot = new Warrior("WarriorBot",
                ValidationInt(getRandomHealth(warrior.getHealth())),
                ValidationInt(getRandomArmor(warrior.getArmor())),
                ValidationInt(getRandomdamageMax(warrior.getDamageMax())),
                ValidationInt(getRandomDamageMin(warrior.getDamageMin())),
                ValidationInt(getRandomLevel(warrior.getLevel())),
                ValidationInt(warrior.getExperience()),
                ValidationInt(getRandomHealth(warrior.getHealth()))) {
            @Override
            public int attack() {

                double a = Math.random();


                if (a <= 0.15) {
                    if (a <= 0.05) {
                        return superAttack();
                    } else {
                        return specialAttack();
                    }
                } else {
                    return (int) ((getDamageMin() + getLevel()) + (getDamageMax() - getDamageMin()) * Math.random());
                }
            }

            @Override
            public int superAttack() {
                return getDamageMax() * 3;
            }

            @Override
            public int specialAttack() {
                return getDamageMin() * 3;
            }

            @Override
            public void getAttack(int attack) {
                System.out.println(attack);
                System.out.println(getArmor());
                attack = attack - 2 * (getArmor() + getLevel() / 2);

                if (attack < 0)
                    attack = 0;

                setHealth(getHealth() - attack);


            }

            @Override
            public void upLevel() {
                setLevel(getLevel() + 1);
            }
        };
        return warriorBot;

    }

    public static void main(String[] angs) {

        WarriorDao warriorDao = new WarriorDao();

        Warrior warrior = warriorDao.getWarrior(433847754);


        System.out.println();

    }





}

