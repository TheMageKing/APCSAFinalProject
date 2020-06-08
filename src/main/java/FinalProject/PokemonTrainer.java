package FinalProject;

import java.util.ArrayList;

public class PokemonTrainer {
    private final String name;
    private final ArrayList<Pokemon> ownedPokemon = new ArrayList<Pokemon>(2);
    private static final int MAX_POKEMON = 2;

    PokemonTrainer(String na){
        name = na;
    }


    /*
    * Adds Pokemon p to the PokemonTrainer's collection of Pokemon.
    * A Player is only allowed MAX_POKEMON Pokemon, so this method
    * will return true if there was room for the new Pokemon and
    * it was successfully added, false if there was no room for the
    * new Pokemon.
    */
    public boolean addPokemon(Pokemon p){
        if(ownedPokemon.size() < MAX_POKEMON){
            ownedPokemon.add(p);
            return true;
        }
        return false;
    }

    /*
    * Returns true if all of the PokemonTrainer's Pokemon
    * have fainted, false otherwise.
    */
    public boolean hasLost(){
        if(getNextPokemon() == null){
            return true;
        }
        return false;
    }

    /*
    * Returns the first Pokemon that has not yet fainted
    * from this PokemonTrainer's collection of Pokemon.
    * If every Pokemon has fainted, this method returns null.
    */
    public Pokemon getNextPokemon(){
        for(Pokemon p : ownedPokemon){
            if(!p.hasFainted()){
                return p;
            }
        }
        return null;
    }
    // Returns this PokemonTrainer's name
    public String toString(){
        return name;
    }
}