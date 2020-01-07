import fight.Arena;
import warrior.Robber;
import warrior.Wizard;

public class Test {


    public static void main(String[] args) {
        Robber robert = new Robber("Robert", 100, 0, 13, 5);

        Robber conan = new Robber("Conan", 155, 0, 10, 6);

        Wizard gandalf = new Wizard("Gandalf", 80, 0, 11, 8);

        Arena arena = new Arena();

        arena.deathBattle(robert, gandalf);

    }
}
