import database.PositionDao;
import database.WarriorDao;
import scanerio.lvl_1.Main;

public class Test {


    public static void main(String[] args) {

        new Main().play(PositionDao.getPosition(160450965));

    }
}
