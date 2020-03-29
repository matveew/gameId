package scanerio;

import scanerio.lvl_1.Main;

public class Position {
    static private String position = "play";


    static public void goAhead(String point) {
        position = position + "." + point;
    }

    static public void goBack() {
        position = position.substring(0, position.lastIndexOf("."));
    }

    static public void action() {
        new Main().play();
    }

    static public void exit() {
        position = "play";
    }

    static String getPosition() {
        return position.substring(position.lastIndexOf(".") + 1);
    }

    static int getCountOfLevel() {
        return Integer.parseInt(position.substring(position.split("\\.").length));
    }

    static public String getPositionByLevel(int lvl) {
        return position.split("\\.")[lvl - 1];
    }

}
