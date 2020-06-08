package FinalProject;

import java.util.ArrayList;

public class Pokemon {
    private final String name;
    private int health = 100;
    private final ArrayList<Move> knownMoves = new ArrayList<Move>(4);

    private String image;
    public static final PokemonImages picFinder = new PokemonImages();

    public Pokemon(String na){
        name = na;
        image = picFinder.getPokemonImage(na);
    }

    public Pokemon(String na, String im){
        this(na);
        image = im;
    }

    /**
     * Returns the name of the Pokemon
     */ 
    public String getName(){
        return name;
    }

    /**
     * Returns how much health this Pokemon has
     */
    public int getHealth(){
        return health;
    }
    /*
    * Returns true if this Pokemon has fainted,
    * False otherwise. A Pokemon faints when their health is
    * less than or equal to 0
    */
    public boolean hasFainted(){
        return health<=0;
    }

    /*
    * A Pokemon can only know 4 Moves. This method
    * returns true if this Pokemon can still learn more
    * Moves, returns false otherwise.
    */
    public boolean canLearnMoreMoves(){
        return knownMoves.size() < 4;
    }

    /*
    * Adds the Move `move` to the collection of Moves
    * that this Pokemon knows. Returns true if the Move was
    * successfully added. Returns false if the Pokemon already
    * knew 4 Moves and couldn't learn a new one.
    */
    public boolean learnMove(Move move){
        if(canLearnMoreMoves()){
            knownMoves.add(move);
            return true;
        }
        return false;

    }

    /*
    * Remove the Move `move` from this Pokemon's
    * collection of Moves, if it's there.
    */
    public void forgetMove(Move move){
        knownMoves.remove(move);

    }

    /**
     * Sets this Pokemon's image to be `image`
     */
    public void setImage(String image){
        this.image = image;
    }

    /**
     * Returns the ASCII Art image for this Pokemon
     */
    public String getImage(){
        return image;
    }

    /*
    * Return a String containing the name and health
    * of this Pokemon
    * Example: "Pikachu (Health: 85 / 100)"
    */
    public String toString(){
        return image+ "\n"+ name + " (Health: " + health + " / 100)";
    }
}