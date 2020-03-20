package warrior.Level;

public class Level {

    static int[] a = new int[]{0 ,10, 20, 30, 50, 70, 100, 130, 170, 220};

    public static int checkLevel(int experience) {

        for (int i = a.length - 1; i >= 0; i--) {
            if (experience >= a[i]) {
                if (i == a.length - 1){
                    return i + 1;
                }
                if (experience < a[i + 1]) {
                    return i + 1;
                }
            }
        }
        return 1 ;
    }

    public static void main(String[]angs){

        System.out.println(checkLevel(300));

    }




}

