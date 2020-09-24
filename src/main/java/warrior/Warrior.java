package warrior;

import org.telegram.telegrambots.meta.api.objects.User;

public abstract class Warrior {

    private int id;
    private String name;
    private int health;
    private int healthFinal;
    private int armor;
    private int damageMin;
    private int damageMax;
    private int level;
    private int experience;
    private User user;


    public Warrior() {
        this.name = "";
        this.level = 1;
        this.health = 100;
        this.healthFinal = 100;
        this.armor = 1;
        this.damageMin = 10;
        this.damageMax = 20;
        this.experience = 0;
    }

    public Warrior(String name, int health, int armor, int damageMax, int damageMin, int level, int experience, int healthFinal) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.armor = armor;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.experience = experience;
        this.healthFinal = healthFinal;
    }

    abstract public int attack();

    abstract public int superAttack();

    abstract public int specialAttack();

    abstract public void getAttack(int attack);

    abstract public void upLevel();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience(){ return experience; }

    public void setExperience(int experience){ this.experience += experience; }

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

    public int getHealthFinal(){
        return  healthFinal;
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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return this.getClass().getName().toLowerCase();
    }
}
