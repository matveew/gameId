package warrior;

public abstract class Warrior {

    private String name;
    private int health;
    private int armor;
    private int damageMin;
    private int damageMax;


    public Warrior() {

        this.name = "default";
        this.health = 0;
        this.armor = 0;
        this.damageMin = 0;
        this.damageMax = 0;
    }

    public Warrior(String name, int health, int armor, int damageMax, int damageMin) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }

    abstract public int attack();


    abstract public int specialAttack();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }


}
