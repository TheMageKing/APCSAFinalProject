package FinalProject;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class PokemonTest {

    Pokemon toTest;
    Pokemon opponent;
    Move a = new Move("one", 1);
    Move b = new Move("two", 2);
    Move c = new Move("three", 3);
    Move d = new Move("four", 4);
    Move e = new Move("five", 5);
    Move aa = new Move("one", 12);

    @Before
    public void prepPokemon(){
        toTest = new Pokemon("Pikachu");
        opponent = new Pokemon("Some Other Dude");
        toTest.learnMove(a);
    }

    @Test
    public void testPrint(){
        toTest.setImage(null);
        assertEquals("Pikachu (Health: 100 / 100)", toTest.toString());
    }

    @Test
    public void fillMoves(){
        assertTrue(toTest.learnMove(b));
        assertTrue(toTest.learnMove(c));
        assertTrue(toTest.learnMove(d));
        assertFalse(toTest.learnMove(e));
        toTest.forgetMove(aa);
        toTest.forgetMove(b);
        assertTrue(toTest.learnMove(e));
    }

    @Test
    public void pokemonImage(){
        PokemonImages images = new PokemonImages();

        // Get an image by Pokemon
        String charmanderImage = images.getPokemonImage(toTest);
        assertEquals(charmanderImage, images.getPokemonImage("Pikachu"));
        System.out.println(toTest);
    }

    @Test
    public void whack(){
        assertTrue(toTest.attack(opponent, a));
        assertTrue(toTest.attack(opponent, aa));
        assertTrue(toTest.attack(opponent, "one"));
        assertFalse(toTest.attack(opponent, b));
        assertEquals(100-3, opponent.getHealth());
    }

    
    

}