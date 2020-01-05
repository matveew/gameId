package fight;

import warrior.Warrior;

public class Arena {


    public void deathBattle(Warrior warrior1, Warrior warrior2) {

        boolean isFight = true;
        while (isFight) {

            int damage = warrior1.attack();
            System.out.println("warrior1.attack() - " + damage);
            warrior2.setHealth(warrior2.getHealth() - damage);
            System.out.println("warrior2.setHealth - " + warrior2.getHealth());

            if (warrior2.getHealth() <= 0) {
                System.out.println("warrior " + warrior1.getName() + " won!");
                return;
            }

            damage = warrior2.attack();
            System.out.println("warrior2.attack() - " + damage);

            warrior1.setHealth(warrior1.getHealth() - damage);
            System.out.println("warrior1.setHealth - " + warrior1.getHealth());
            if (warrior1.getHealth() <= 0) {
                System.out.println("warrior " + warrior2.getName() + " won!");
                return;
            }


        }


    }


    void roundBatlle(Warrior warrior1, Warrior warrior2, int countRound) {

    }
}



