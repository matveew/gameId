package scanerio;


import database.PositionDao;
import scanerio.lvl_1.Main;

public class Position {
    private int id;
    private String position;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void goAhead(String point) {
        position = position + "." + point;
        PositionDao.setPosition(id, position);
    }

    public void goBack() {
        position = position.substring(0, position.lastIndexOf("."));
        PositionDao.setPosition(id, position);

    }

    public void action() {
        new Main().play(this);
    }

    public void exit() {
        position = "play";
        PositionDao.setPosition(id, position);

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    int getCountOfLevel() {
        return Integer.parseInt(position.substring(position.split("\\.").length));
    }

    public String getPositionByLevel(int lvl) {

        if (position.split("\\.").length < lvl) {
            return "";
        }

        return position.split("\\.")[lvl - 1];
    }

}
