package task;

import java.util.Scanner;

public class Task {

    int a = (int) (Math.random() * 10);
    int b = (int) (Math.random() * 10);
    int c = (int) (Math.random() * 10);

    int answer;

    public String getTaskLevel1() {
        if (Math.random() > 0.5) {

            answer = a + b;

            return a + " + " + b + " = ?";

        } else {
            if (b > a) {
                int c;
                c = b;
                b = a;
                a = c;
            }

            answer = a - b;

            return a + " - " + b + " = ?";

        }

    }

    public String getTaskLevel2 (){
        if (Math.random() > 0.5) {

            answer = a * b;

            return a + " * " + b + " = ?";

        }
        else {
            if (b > a) {
                int c;
                c = b;
                b = a;
                a = c;
            }
            if ( a % b != 0  )

                a *= b;

            answer = a / b;

            return a + " / " + b + " = ?";

        }

    }


    public String getTaskLevel3(){



        if (Math.random() < 0.3) {

            answer = a * b * c;

            return a + " * " + b + " * " + c + " = ?";

        }
        if(Math.random() < 0.6){
                a *= c;
                b *= c;

            answer = a * b / c;

            return a + " * " + b + " / " + c + " = ?";
        }

        if ( a % b != 0  )
            a *= b;

        return a + " / " + b + " * " + c + " = ?";

    }

    public boolean checkAnswer(int answerUser) {
        if (answer == answerUser)
            return true;
        return false;
    }


}
