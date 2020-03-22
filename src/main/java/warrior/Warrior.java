package warrior;

import org.telegram.telegrambots.meta.api.objects.User;

public class Warrior {

    private int id;

    private String name;
    private int health;
    private int armor;
    private int damageMin;
    private int damageMax;
    private int level;

    private User user;

    public Warrior() {
    }

    public Warrior(String name, int health, int armor, int damageMax, int damageMin, int level) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.armor = armor;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }


    public int attack() {
        return 0;
    }


    public int superAttack() {
        return 0;
    }


    public int specialAttack() {
        return 0;
    }


    public void getAttack(int attack) {
    }


    public void upLevel() {
    }


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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
