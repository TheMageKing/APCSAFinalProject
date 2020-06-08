package FinalProject;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class PokemonTest {

    Pokemon toTest;
    Move a = new Move("one", 1);
    Move b = new Move("two", 2);
    Move c = new Move("three", 3);
    Move d = new Move("four", 4);
    Move e = new Move("five", 5);
    Move aa = new Move("one", 12);

    @Before
    public void prepPokemon(){
        toTest = new Pokemon("Pikachu");
    }

    @Test
    public void testPrint(){
        assertEquals("Pikachu (Health: 100 / 100)", toTest.toString());
    }

    @Test
    public void fillMoves(){
        assertTrue(toTest.learnMove(a));
        assertTrue(toTest.learnMove(b));
        assertTrue(toTest.learnMove(c));
        assertTrue(toTest.learnMove(d));
        assertFalse(toTest.learnMove(e));
        toTest.forgetMove(aa);
        toTest.forgetMove(b);
        assertTrue(toTest.learnMove(e));
    }
    
    

}