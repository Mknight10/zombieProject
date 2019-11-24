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
        for (int i = 0; i < rand.nextInt(55); i++ ){
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

        System.out.println("tank count" + tankCount);
        System.out.println("common count" + commonCount);
        System.out.println("soldier count" + soldierCount);
        System.out.println("teacher count " + teacherCount);
        System.out.println("child count" + childCount);

        // shuffle arraylist orders
        Collections.shuffle(zombies);
        Collections.shuffle(survivors);

        System.out.println("\n We have " + survivors.size() + " survivors trying to make it to safety.\n");
        System.out.println("But there are " + zombies.size() + " zombies waiting for them. \n");

        for (int i = 0; i < survivors.size(); i++) {
            Character survivor = survivors.get(i);
                for (int i1 = 0; i1 < zombies.size(); i1++) {
                    Character zombie = zombies.get(i1);
                        while (zombie.isAlive() && survivor.isAlive()) {

                            // for testing only
                            /* System.out.println(zombie.name);
                            System.out.println(zombie.health);
                            System.out.println(survivor.name);
                            System.out.println(survivor.health); */

                            zombie.health -= survivor.attack;
                            survivor.health -= zombie.attack;
                        }
                    zombies.remove(zombie);
                    System.out.println(zombies.size() + " zombies remain");
                }
            survivors.remove(survivor);
            System.out.println(survivors.size() + " survivors remain");
        }
        if (zombies.size() > survivors.size()) {
            System.out.println("There were no survivors and " + zombies.size() + " zombies remained.");
        } else {
            System.out.println("There were " + survivors.size() + " survivors that made it!");
        }
    }
}