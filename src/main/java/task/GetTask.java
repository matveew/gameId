package task;

import javafx.geometry.Pos;
import scanerio.Position;

public class GetTask {

    Position position = new Position();

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


    public String getTaskLevel2() {
        if (Math.random() > 0.5) {

            answer = a * b;

            return a + " \\* " + b + " = ?";

        } else {
            if (b > a) {
                int c;
                c = b;
                b = a;
                a = c;
            }

            if (b == 0)
                b = 1;

            if (a % b != 0)
                a *= b;


            answer = a / b;

            return a + " / " + b + " = ?";

        }

    }


    public String getTaskLevel3() {


        if (Math.random() < 0.3) {

            answer = a * b * c;

            return a + " \\* " + b + " \\* " + c + " = ?";

        }
        if (Math.random() < 0.6) {

            if (c == 0)
                c = 1;

            a *= c;
            b *= c;


            answer = a * b / c;

            return a + " \\* " + b + " / " + c + " = ?";
        }

        if (a % b != 0)
            a *= b;

        if (b == 0)
            b = 1;

        answer = a / b * c;

        return a + " / " + b + " \\* " + c + " = ?";
    }


    public String toStringAnswer() {

        return Integer.toString(answer);
    }


    public void saveAnswer(Position position, String answer) {

        position.goAhead(answer);
    }


}
