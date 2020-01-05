import fight.Arena;
import warrior.Robber;

public class Test {




    public static void main(String[] args) {
        Robber robert = new Robber("Robert", 100, 0, 13, 5);

        Robber conan = new Robber("Conan", 200, 0, 7, 3);


        Arena arena = new Arena();

        arena.deathBattle(robert, conan);

    }
}
