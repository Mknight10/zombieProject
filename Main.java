import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        ArrayList<ZombieAbstract>zombies = new ArrayList<>();
        ArrayList<Survivor>survivors = new ArrayList<>();

        // add random number of tanks to zombie arraylist
        for (int i = 0; i < rand.nextInt(15); i++ ){
            zombies.add(new TankZombie());
        }
        // add random number of common infects to zombie arraylist
        for (int i = 0; i < rand.nextInt(15); i++) {
            zombies.add(new CommonInfect());
        }

        // add soldier to survivor arraylist
        for (int i = 0; i < rand.nextInt(10); i++){
            survivors.add(new Soldier());
        }
        // shuffle zombie arraylist
        Collections.shuffle(zombies);

        // testing purposes only
        System.out.println(zombies.size());
        System.out.println(survivors.size());
        System.out.println(zombies);
        System.out.println(zombies);

    }
}
