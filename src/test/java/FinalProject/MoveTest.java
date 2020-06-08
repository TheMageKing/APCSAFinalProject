package FinalProject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class MoveTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void givenTest() {
        Move t = new Move("Water Gun", 15);
        assertEquals("Water Gun", t.getName());
        assertEquals(15, t.getDamage());
        assertEquals("Water Gun (15 Damage)", t.toString());
    }

    @Test
    public void tooMuchDamageTest(){
        Move t = new Move("Bob", 30);
        assertEquals(25, t.getDamage());
    }
}
