package com.drkharma.vmf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Articulation}
 */
public class ArticulationTest {

    /**
     * Tests an articulation lookup with a valid code
     */
    @Test
    public void testGetArticulation001() {
        Articulation actual = Articulation.getArticulation(4);

        assertEquals(Articulation.STACCATISSIMO, actual);
    }

    /**
     * Tests an articulation lookup with a code less than 3.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetArticulation002() {
        @SuppressWarnings("unused")
		Articulation actual = Articulation.getArticulation(-4);
    }

    /**
     * Tests an articulation lookup with a code greater than 7.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetArticulation003() {
        @SuppressWarnings("unused")
		Articulation actual = Articulation.getArticulation(10);
    }

    /**
     * Tests an articulation lookup with a code of 0.
     */
    @Test()
    public void testGetArticulation004() {
        Articulation actual = Articulation.getArticulation(0);

        assertEquals(Articulation.NONE, actual);
    }

    /**
     * Tests the retrival of an articulation code.
     */
    @Test
    public void testGetArticulationCode001() {
        assertEquals(3, Articulation.STACCATO.getArticulationCode());
    }
}