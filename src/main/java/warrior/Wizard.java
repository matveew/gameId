package warrior;

public class Wizard extends Warrior {

    public Wizard() {
    }

    public Wizard(String name, int health, int armor, int damageMax, int damageMin) {
        super(name, health, armor, damageMax, damageMin);
    }


    public int attack() {


        if (Math.random() < 0.2)
            return specialAttack();
        else
            return (int) (getDamageMin() + (getDamageMax() - getDamageMin()) * Math.random());


    }

    public int specialAttack() {
        return getDamageMax() * (getName().length() / 2);

    }
}
