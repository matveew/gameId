package warrior;

import java.util.Random;

public class Robber extends Warrior {

    Random random = new Random();

    public Robber(String name, int health, int armor, int damageMax, int damageMin) {
        super(name, health, armor, damageMax, damageMin);
    }

    @Override
    public int attack() {


        if (Math.random() < 0.2)
            return specialAttack();
        else
            return (int) (getDamageMin() + (getDamageMax() - getDamageMax()) * Math.random());


    }

    @Override
    public int specialAttack() {
        return getDamageMax() * 3;
    }
}
