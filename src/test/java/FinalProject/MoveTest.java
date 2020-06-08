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
        Move t = new Move("Bob", 26);
        assertEquals(25, t.getDamage());
    }

    @Test
    public void tooLittleDamageTest(){
        Move t = new Move("Mike", -1);
        assertEquals(0, t.getDamage());
    }

    @Test
    public void equalityTest(){
        Move t = new Move("Bob", 20);
        Move b = new Move("Phil", 21);
        Move d = new Move("Bob", 29);
        assertTrue("IsEqual works", t.equals(d));
        assertFalse("IsNotEqual works", t.equals(b));
    }
}
