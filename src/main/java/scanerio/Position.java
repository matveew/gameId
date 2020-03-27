package scanerio;

public class Position {
    static private String position ="play";


    static public void in(String point) {
        position = position + "." + point;
    }

    static public void out() {
        position = position.substring(0, position.lastIndexOf("."));
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
