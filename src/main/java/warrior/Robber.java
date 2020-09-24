package warrior;

import java.util.Random;

public class Robber extends Warrior {


    public Robber() {

    }

    public Robber(String name, int health, int armor, int damageMax, int damageMin, int level, int expirience, int healthFinal) {
        super(name, health, armor, damageMax, damageMin, level, expirience, healthFinal);
    }

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

    public int superAttack() {
        return getDamageMax() * 3;
    }


    @Override
    public int specialAttack() {
        return getDamageMin() * 3;
    }

    public void getAttack(int attack) {
        System.out.println(attack);
        System.out.println(getArmor());
        attack = attack - 2 * (getArmor() + getLevel() / 2);

        if (attack < 0)
            attack = 0;

        setHealth(getHealth() - attack);


    }

    public void upLevel() {
        setLevel(getLevel() + 1);
    }


}
