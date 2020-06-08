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

    public static PokemonTrainer setupPlayerTrainer(){
        ConsoleProgram.readLine("'Trainer', what is your NAME? ");
        String name = ConsoleProgram.readLine("Don't lie to me, so-called 'Trainer'.  WHAT. IS. YOUR. NAME! ");
        PokemonTrainer trainer = new PokemonTrainer(name);
        System.out.println();
        System.out.println("Okay, fine, we'll go with that.  Lets setup your ~slaves~ pokemon.");
        System.out.println();
        trainer.addPokemon(setupPlayerPokemon());
        System.out.println();
        ConsoleProgram.readLine("You sure? He seems puny.  Have you been feeding the poor bastard enough? ");
        System.out.println("No? Nor will you ever? Poor thing.  I'd call PETP, but SOMEONE (you) cut off my phone");
        System.out.println("Oh well.  We'll go on to your seccond ~enslaved innocent~ pokemon");
        System.out.println();
        trainer.addPokemon(setupPlayerPokemon());

        return trainer;
    }

    public static Pokemon setupPlayerPokemon(){
        Pokemon p = new Pokemon(ConsoleProgram.readLine("Pokemon's name?"));
        System.out.println("Now lets teach 'em some MOVES");
        while(p.canLearnMoreMoves()){
            String name = ConsoleProgram.readLine("Whats the move named?");
            int damage = ConsoleProgram.readInt("How much damage does it do?");
            System.out.println("Forging the move... okay!");
            p.learnMove(new Move(name, damage));
            System.out.println();
            if(!ConsoleProgram.readBoolean("Wanna teach another? (Y/N)")){
                break;
            }
            if(!p.canLearnMoreMoves()){
                System.out.println("Too bad! Your poor 'assistant' has learned all they could, with how little they have been fed lately");
            }
            System.out.println();
        }
        System.out.println("Here is the poor bastard you produced:");
        System.out.println(p);
        return p;
    }

    public String getNextMove(){
        System.out.print("\nHere are the moves you know:");
        Pokemon p = getNextPokemon();
        System.out.println(p.getMoves() + "\n");
        String ret = null;
        while(ret == null){
            String mv = ConsoleProgram.readLine("What move would you like to use?");
            if(p.knowsMove(mv)){
                ret = mv;
            }
        }
        return ret;
    }
}