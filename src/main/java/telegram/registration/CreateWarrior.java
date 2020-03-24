package telegram.registration;

import createWarrior.Create;
import database.GameDB;

import org.telegram.telegrambots.meta.api.objects.User;
import warrior.Warrior;

public class CreateWarrior {
    User user;
    Warrior warrior;

    public void setUser(User user) {
        this.user = user;
    }

    public void setTypeWarrior(String typeWarrior) {
        warrior = Create.newWarrior(typeWarrior);
        warrior.setUser(user);
        warrior.setId(user.getId());
    }

    public void setNameWarrior(String name) {
        this.warrior.setName(name);
    }

    public void save() {
        GameDB.saveNewWarrior(warrior);
    }


}
