package fight;

import warrior.Warrior;

public class Arena {


    public void deathBattle(Warrior warrior1, Warrior warrior2) {

        System.out.println(warrior1.getName() + " " + warrior1.getLevel());
        System.out.println(warrior2.getName() + " " + warrior2.getLevel());
        boolean isFight = true;


        while (isFight) {

            warrior2.getAttack(warrior1.attack());
            System.out.println("warrior2.setHealth - " + warrior2.getHealth());

            if (warrior2.getHealth() <= 0) {
                warrior1.upLevel();
                System.out.println("warrior1 " + warrior1.getName() + " won!");
                return;
            }

            warrior1.getAttack(warrior2.attack());

            System.out.println("warrior1.setHealth - " + warrior1.getHealth());
            if (warrior1.getHealth() <= 0) {
                warrior2.upLevel();
                System.out.println("warrior2 " + warrior2.getName() + " won!");
                return;
            }


        }


    }


    void roundBatlle(Warrior warrior1, Warrior warrior2, int countRound) {

    }
}



