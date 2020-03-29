package global;

import warrior.Warrior;

public class GlobalWarrior {

    static public Warrior warrior;


    static public Warrior getWarrior() {
        return warrior;
    }

    static public void setWarrior(Warrior warrior) {
        GlobalWarrior.warrior = warrior;


    }


}
