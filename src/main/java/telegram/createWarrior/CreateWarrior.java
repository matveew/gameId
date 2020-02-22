package telegram.createWarrior;

import warrior.Robber;
import warrior.Warrior;
import warrior.Wizard;

public class CreateWarrior {
    int idUser;


    public CreateWarrior(int idUser) {
        this.idUser = idUser;
    }


    public Warrior create(String type) {
        if (type.equals("robber"))
            return new Robber();

        if (type.equals("wizard"))
            return new Wizard();

        return null;
    }

    public void setName(String type) {


    }

    public void setType(String type) {

    }

    public void saveWarrior() {

    }


}
