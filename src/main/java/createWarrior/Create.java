package createWarrior;

import warrior.Robber;
import warrior.Warrior;
import warrior.Wizard;

public class Create {

  public   static Warrior newWarrior(String type) {

        switch (type) {
            case "wizard":
                return new Wizard();
            case "robber":
                return new Robber();
        }
        return null;
    }


}
