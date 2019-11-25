package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static int tankCount = 0;
    public static int commonCount = 0;
    public static int soldierCount = 0;
    public static int teacherCount = 0;
    public static int childCount = 0;
    public static int zombiesKilled = 0;
    public static int survivorsKilled = 0;

    public static void main(String[] args) {
        Random rand = new Random();

        ArrayList<Character>zombies = new ArrayList<>();
        ArrayList<Character>survivors = new ArrayList<>();

        createZombies(zombies);
        createSurvivors(survivors);

        // shuffle arraylist orders
        Collections.shuffle(zombies);
        Collections.shuffle(survivors);

        System.out.println("\n We have " + survivors.size() + " survivors trying to make it to safety.\n" +
                "(" + childCount + " Children, " + teacherCount + " Teachers, " + soldierCount + " Soldiers) \n");
        System.out.println("But there are " + zombies.size() + " zombies waiting for them. \n" +
                "(" + tankCount + " Tank Zombies, " + commonCount + " Common Infects) \n");

        int survivorCount = survivors.size();
        int zombieCount = zombies.size();

        for (int i = 0; i < survivors.size(); i++) {
            Character survivor = survivors.get(i);

            for (int j = 0; j < zombies.size(); j++) {
                Character zombie = zombies.get(j);

                while (zombie.isAlive() && survivor.isAlive()) {

                    zombie.health -= survivor.attack;
                    survivor.health -= zombie.attack;

                    if (zombie.health <= 0) {
                        System.out.println(survivor.name + " " + i + " killed " + zombie.name + " " + j);
                        zombiesKilled++;
                    }
                    if (survivor.health <= 0) {
                        System.out.println(zombie.name + " " + j + " killed " + survivor.name + " " + i);
                        survivorsKilled++;
                    }
                }
            }
        }
        if (zombieCount - zombiesKilled != 0) {
            System.out.println("No survivors made it...");
        } else {
            System.out.println((survivorCount - survivorsKilled) + " survivors made it!");
        }
    }

    private static void printResults (ArrayList zombies, ArrayList survivors ) {
        if (zombies.size() > survivors.size()) {
            System.out.println("There were no survivors and " + zombies.size() + " zombies remained.");
        } else if (survivors.size() > zombies.size()){
            System.out.println("There were " + survivors.size() + " survivors that made it!");
        }
    }

    private static ArrayList createZombies (ArrayList zombies) {
        Random rand = new Random();
        // add random number of tanks to zombie arraylist
        for (int i = 0; i < rand.nextInt(5); i++ ){
            zombies.add(new TankZombie());
            tankCount++;
        }
        // add random number of common infects to zombie arraylist
        for (int i = 0; i < rand.nextInt(10); i++) {
            zombies.add(new CommonInfect());
            commonCount++;
        }
        return zombies;
    }

    private static ArrayList createSurvivors (ArrayList survivors) {
        Random rand = new Random();
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
        return survivors;
    }
}