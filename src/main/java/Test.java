import fight.Arena;
import warrior.Robber;
import warrior.Wizard;

public class Test {



    public static void main(String[] args) {



        Robber robert = new Robber("Robert", 100, 1, 10, 7, 1);

        Robber conan = new Robber("Conan", 150, 2, 7, 5, 1);

        Wizard gandalf = new Wizard("Gandalf", 80, 2, 11, 8, 1);

        Arena arena = new Arena();

        arena.deathBattle(robert, conan);

    }
}
