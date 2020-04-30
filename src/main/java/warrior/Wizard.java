package warrior;

public class Wizard extends Warrior {



    public Wizard() {
    }

    public Wizard(String name, int health, int armor, int damageMax, int damageMin, int level) {
        super(name, health, armor, damageMax, damageMin, level);
    }


    public int attack() {


        if (Math.random() < 0.2)
            return specialAttack();
        else
            return (int) (getDamageMin() + (getDamageMax() - getDamageMin()) * Math.random());


    }

    public int superAttack() {
        return 0;
    }

    public int specialAttack() {
        return getDamageMax() * (getName().length() / 2);

    }

    public void getAttack(int attack) {

    }

    public void upLevel() {
    }



    public int getAttack() {
        return 0;
    }
}
