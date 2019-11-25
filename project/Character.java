package project;

public abstract class Character {
    String name;
    int health;
    int attack;

    @Override
    public String toString() {
        return "project.Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                '}';
    }

    public boolean isAlive(){
        if (health > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
