import createWarrior.Create;
import global.GlobalWarrior;
import scanerio.Position;

public class Test {


    public static void main(String[] args) {

        String test = "Robber.robert.new.Robbero.lololo";
        GlobalWarrior.setWarrior(Create.newWarrior(Position.getPositionByLevel(54)));



        System.out.println(test.split("\\.")[0]);
/*
        Robber robert = new Robber("Robert", 100, 1, 10, 7, 1);

        Robber conan = new Robber("Conan", 150, 2, 7, 5, 1);

        Wizard gandalf = new Wizard("Gandalf", 80, 2, 11, 8, 1);

        Arena arena = new Arena();

        arena.deathBattle(robert, conan);*/

    }
}
