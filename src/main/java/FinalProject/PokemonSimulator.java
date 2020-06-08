package FinalProject;

public class PokemonSimulator extends ConsoleProgram{
    PokemonTrainer playerOne;
    PokemonTrainer playerTwo;

    public void initGame(){
        println("Welcome (to) the Pokemon Simulator OF DOOM");
        println("Please note that tildes surrounding words indicate a strikethrough");
        println("Anyways, time to get to work");
        println("Setup first ~cruel overseer~ 'trainer'");
        playerOne = setupPokemonTrainer();
        println("Thats it for that trainer.  Off to number 2!  I hope they ~kill you~ have a nice day");
        println("Give them the computer! That's it.  Off we go again!");
        playerTwo = setupPokemonTrainer();
    
    }

    private PokemonTrainer setupPokemonTrainer(){
        readLine("'Trainer', what is your NAME? ");
        String name = readLine("Don't lie to me, so-called 'Trainer'.  WHAT IS YOUR TRUE NAME! ");
        PokemonTrainer trainer = new PokemonTrainer(name);
        println();
        println("Okay, fine, we'll go with that.  Lets setup your ~slaves~ pokemon.");
        println();
        trainer.addPokemon(setupPokemon());
        println();
        readLine("You sure? He seems puny.  Have you been feeding the poor bastard enough? ");
        println("No? Nor will you ever? Poor thing.  I'd call PETP, but SOMEONE (you) cut off my phone");
        println("Oh well.  We'll go on to your seccond ~enslaved innocent~ pokemon");
        println();
        trainer.addPokemon(setupPokemon());



        return trainer;
    }

    private Pokemon setupPokemon(){
        Pokemon p = new Pokemon(readLine("Pokemon's name?"));
        println("Now lets teach 'em some MOVES");
        while(p.canLearnMoreMoves()){
            String name = readLine("Whats the move named?");
            int damage = readInt("How much damage does it do?");
            println("Forging the move... okay!");
            p.learnMove(new Move(name, damage));
            println();
            if(!readBoolean("Wanna teach another? (Y/N)")){
                break;
            }
            if(!p.canLearnMoreMoves()){
                println("Too bad! Your poor 'assistant' has learned all they could, with how little they have been fed lately");
            }
            println();
        }
        println("Here is the poor bastard you produced:");
        println(p);
        return p;
    }
    

}