package FinalProject;

public class Move{
    // Private constants
    private static final int MAX_DAMAGE = 25;
    private final int damage;
    private final String name;

    public Move(String na, int dmg){
        name = na;
        damage = (dmg> MAX_DAMAGE)? 25 : dmg;
    }
    
    /**
     * Returns the name of the Move
     */
    public String getName(){
        return name;
    }

    /**
     * Returns how much damage this Move does
     */
    public int getDamage(){
        return damage;
    }

    /**
     * Returns a String representation of this Move
     * Example: "Water Gun (15 Damage)"
     */
    public String toString(){
        return name +  " (" + damage + " Damage)";

    }

    @Override
    public boolean equals(Object m){
        Move b = (Move) m;
        return b.name.equals(name);
    }
}