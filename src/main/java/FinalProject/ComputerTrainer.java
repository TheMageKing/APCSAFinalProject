package FinalProject;

public class ComputerTrainer extends PokemonTrainer {
    // private constants
    // Possible pokemon names and move names to generate random Pokemon
    private static final String[] POKEMON_NAMES = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Bob"};
	private static final String[] MOVE_NAMES = {"Tailwhip", "Bodyslam", "Splash", "Shock", "Smack", "Whack", "Kick", "Lick"};
	private static final int MAX_DAMAGE = 25;
	private static final int MAX_MOVES = 4;



    /*
    * Write a Constructor that sets the name of the
    * ComputerTrainer to be the name passed in, and adds
    * 2 randomly generated Pokemon to its collection
    * of Pokemon.
    */
    public ComputerTrainer(String name){
        super(name);
        addRandomPokemon();
        addRandomPokemon();
    }
    
    /*
    * Adds a randomly generated Pokemon to this ComputerTrainer's
    * collection of Pokemon. A ComputerTrainer can only have 2
    * Pokemon. This method returns true if there was room for the
    * new Pokemon and it was successfully added, false otherwise.
    */
    public boolean addRandomPokemon(){
        String name = POKEMON_NAMES[(int)Math.random()*POKEMON_NAMES.length];
        Pokemon p = new Pokemon(name);
        for(int x = 0; x < MAX_MOVES; x++){
            name = MOVE_NAMES[(int) (Math.random()*MOVE_NAMES.length)];
            int damage = (int)(Math.random()*MAX_DAMAGE + 1);
            p.learnMove(new Move(name, damage));
        }
        return addPokemon(p);
    }

    /*
    * Returns a Move randomly chosen from the set of Moves
    * that this trainer's current Pokemon knows.
    * If all Pokemon have fainted, returns null.
    */
    public Move chooseRandomMove(){
        return getNextPokemon().getMoves().get((int)(Math.random()*MAX_MOVES));

    }

    @Override
    public String getNextMove(){
        return chooseRandomMove().toString();
    }
}