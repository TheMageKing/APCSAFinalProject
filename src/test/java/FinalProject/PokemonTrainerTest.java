package FinalProject;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class PokemonTrainerTest{
    PokemonTrainer toTest;
    Pokemon p;


    @Before
    public void prep(){
        toTest = new PokemonTrainer("bob");
        p = new Pokemon("marge");
        p.learnMove(new Move("Smack", 10));
        toTest.addPokemon(p);
    }

    @Test
    public void names(){
        assertEquals("bob", toTest.toString());
    }

    @Test
    public void getFainted(){
        Pokemon e = toTest.getNextPokemon();
        assertNotNull(e);
        Pokemon d = new Pokemon("Die");
        d.learnMove(new Move("Burn", 100));
        d.attack(e, "Burn");
        d.attack(e, "Burn");
        d.attack(e, "Burn");
        d.attack(e, "Burn");
        assertNull(toTest.getNextPokemon());
        assertTrue(toTest.hasLost());
        toTest.addPokemon(d);
        assertEquals(toTest.getNextPokemon(), d);
    }

}