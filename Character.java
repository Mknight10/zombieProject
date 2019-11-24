public abstract class Character {
    String name;
    int health;
    int attack;
    boolean isAlive;

    @Override
    public String toString() {
        return "Character{" +
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
