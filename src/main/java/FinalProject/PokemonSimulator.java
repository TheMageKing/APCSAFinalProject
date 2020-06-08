package FinalProject;

public class PokemonSimulator extends ConsoleProgram {
    PokemonTrainer playerOne;
    PokemonTrainer playerTwo;

    public void initGame(){
        println("Welcome (to) the Pokemon Simulator OF DOOM");
        println("Please note that tildes surrounding words indicate a strikethrough");
        println("Anyways, time to get to work");
        println("Setup first ~cruel overseer~ 'trainer'");
        playerOne = PokemonTrainer.setupPlayerTrainer();
        println("Thats it for that trainer.  Off to number 2!  I hope they ~kill you~ have a nice day");
        println("Give them the computer! That's it.  Off we go again!");
        playerTwo = PokemonTrainer.setupPlayerTrainer();
        println("Let the fighting... BEGIN!");
    }

    public PokemonTrainer runFight(){
        while(true){
            if(runHalfRound(playerOne, playerTwo)){
                println(playerOne.toString() +" (Player one) WINS!");
                return playerOne;
            }
            if(runHalfRound(playerTwo, playerOne)){
                println(playerTwo.toString() +" (Player two) WINS!");
                return playerTwo;
            }
        }
    }

    public boolean runHalfRound(PokemonTrainer attacker, PokemonTrainer defender){
        String attackerMove = attacker.getNextMove();
        attacker.getNextPokemon().attack(defender.getNextPokemon(), attackerMove);
        return defender.hasLost();
    }

    

}