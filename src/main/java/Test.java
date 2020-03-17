import fight.Arena;
import warrior.Robber;
import warrior.Wizard;

import java.util.Scanner;

public class Test {


    public static void main(String[] args) {


        while (true) {

            int a = (int) (Math.random() * 10);
            int b = (int) (Math.random() * 10);

            System.out.println(a + " + " + b + " = " + " ?");
            int answer = new Scanner(System.in).nextInt();
            if (answer == (a + b)) {
                System.out.println("Right!");
            } else {
                System.out.println("Wrong!  answer: " + (a + b));
            }
        }


    }
}
