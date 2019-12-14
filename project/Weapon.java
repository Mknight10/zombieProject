package project;

import java.util.Random;

public abstract class Weapon {
    String name;
    int damage;
    double accuarcy;
   }
   
public boolean hit(Weapon weapon){
  Random generator = new Random();
  int number = generator.nextInt(100);
  double result = number / 100.0;
  if (result < wepon.accuarcy){
    return(true);
   }
  else{
    return(false);
   }
   
   
