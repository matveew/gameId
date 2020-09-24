package scanerio.lvl_1.lvl_2;

import warrior.Warrior;

public class LevelCheck {

    int[] expirienceArray = new int[]{20, 50, 100, 200, 400, 800, 1600, 3200};


    public void checkLevel(Warrior warrior) {

        int level = expirienceToLevel(warrior.getExperience());

        warrior.setLevel(level);

    }


    private int expirienceToLevel(int expirience) {

        int level = 0;

        for (int i = 0; i <= expirienceArray.length - 1; i++) {
            if (expirienceArray[i] <= expirience) {
                level = i;
            }
        }

        return level + 1;


    }



}
