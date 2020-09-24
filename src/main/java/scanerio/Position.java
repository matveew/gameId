package scanerio;


import database.PositionDao;
import scanerio.lvl_1.Main;

public class Position {
    private int id;
    private String position;
    private int idPositionWarriorAdversery;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void goAhead(String point) {

        if (position.isEmpty()) {
            position = point;
            PositionDao.setPosition(id, position,idPositionWarriorAdversery);
        } else {
            position = position + "." + point;
            PositionDao.setPosition(id, position,idPositionWarriorAdversery);
        }
    }

    public void goBack() {
        position = position.substring(0, position.lastIndexOf("."));
        PositionDao.setPosition(id, position,idPositionWarriorAdversery);

    }

    public void action() {
        new Main().play(this);
    }

    public void exit() {
        position = "";
        PositionDao.setPosition(id, position,idPositionWarriorAdversery);
    }

    public void exitIdPositionWarriorAdversery(){
        idPositionWarriorAdversery = 0;
        PositionDao.setPosition(id,position,idPositionWarriorAdversery);
    }

    public String getPosition() {
        return position;
    }



    public void setPosition(String position) {
        this.position = position;
    }

    public int getIdPositionWarriorAdversery(){
        return idPositionWarriorAdversery;
    }

    public void setIdPositionWarriorAdversery(int idPositionWarriorAdversery){
        this.idPositionWarriorAdversery = idPositionWarriorAdversery;
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

    public void deleteWrongPosition(Position position, String stringPosition){
        position.exit();
        setPosition(stringPosition);
    }

    public String getLastPosition(){

        String[] str;

        str = position.split("\\.");

        return str[str.length - 1];

    }

}
