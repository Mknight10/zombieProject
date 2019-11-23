import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        ArrayList<ZombieAbstract>zombies = new ArrayList<>();
        ArrayList<Survivor>survivors = new ArrayList<>();

        for (int i = 0; i < rand.nextInt(15); i++ ){
            zombies.add(new TankZombie());
        }

        for (int i = 0; i < rand.nextInt(15); i++) {
            zombies.add(new CommonInfect());
        }

        for (int i = 0; i < rand.nextInt(10); i++){
            survivors.add(new Soldier());
        }

        System.out.println(zombies.size());
        System.out.println(survivors.size());
        System.out.println(zombies);
        Collections.shuffle(zombies);
        System.out.println(zombies);

    }
}
