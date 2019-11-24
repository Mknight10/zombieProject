import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        int tankCount = 0;
        int commonCount = 0;
        int soldierCount = 0;
        int teacherCount = 0;
        int childCount = 0;

        ArrayList<Character>zombies = new ArrayList<>();
        ArrayList<Character>survivors = new ArrayList<>();
        
        // add random number of tanks to zombie arraylist
        for (int i = 0; i < rand.nextInt(15); i++ ){
            zombies.add(new TankZombie());
            tankCount++;
        }
        // add random number of common infects to zombie arraylist
        for (int i = 0; i < rand.nextInt(15); i++) {
            zombies.add(new CommonInfect());
            commonCount++;
        }


        // add soldier to survivor arraylist
        for (int i = 0; i < rand.nextInt(10); i++){
            survivors.add(new Soldier());
            soldierCount++;
        }

        // add teacher to survivor arraylist
        for (int i = 0; i < rand.nextInt(10); i++){
            survivors.add(new Teacher());
            teacherCount++;
        }

        // add soldier to survivor arraylist
        for (int i = 0; i < rand.nextInt(10); i++){
            survivors.add(new Child());
            childCount++;
        }

        // shuffle arraylist orders
        Collections.shuffle(zombies);
        Collections.shuffle(survivors);

        System.out.println("\n We have " + survivors.size() + " survivors trying to make it to safety.\n");
        System.out.println("But there are " + zombies.size() + " zombies waiting for them. \n");

        for (Character survivor : survivors) {
            while (survivor.isAlive()) {
                for (Character zombie : zombies) {
                    while (zombie.isAlive() && survivor.isAlive()) {
                        System.out.println(zombie.name);
                        System.out.println(zombie.health);
                        System.out.println(survivor.name);
                        System.out.println(survivor.health);
                        zombie.health -= survivor.attack;
                        survivor.health -= zombie.attack;
                    }
                }
            }
        }
    }
}