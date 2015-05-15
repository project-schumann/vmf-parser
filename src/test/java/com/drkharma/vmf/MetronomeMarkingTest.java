package com.drkharma.vmf;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class for {@link MetronomeMarking}
 */
public class MetronomeMarkingTest {

    /**
     * Test equality check for an equivalent object.
     */
    @Test
    public void testEquals001() {
        MetronomeMarking mm1 = new MetronomeMarking(0, 100);
        MetronomeMarking mm2 = new MetronomeMarking(0, 100);

        boolean actual = mm1.equals(mm2);

        assertTrue(actual);
    }

    /**
     * Equality check with a null object.
     */
    @Test
    public void testEquals002() {
        MetronomeMarking mm1 = new MetronomeMarking(0, 100);

        boolean actual = mm1.equals(null);

        assertFalse(actual);
    }

    /**
     * Equality check with an object of a different type.
     */
    @Test
    public void testEquals003() {
        MetronomeMarking mm1 = new MetronomeMarking(0, 100);

        boolean actual = mm1.equals("hello world.");

        assertFalse(actual);
    }

    /**
     * Test equality check with different measure.
     */
    @Test
    public void testEquals004() {
        MetronomeMarking mm1 = new MetronomeMarking(0, 100);
        MetronomeMarking mm2 = new MetronomeMarking(10, 100);

        boolean actual = mm1.equals(mm2);

        assertFalse(actual);
    }

    /**
     * Test equality check with different BPM.
     */
    @Test
    public void testEquals005() {
        MetronomeMarking mm1 = new MetronomeMarking(0, 100);
        MetronomeMarking mm2 = new MetronomeMarking(0, 120);

        boolean actual = mm1.equals(mm2);

        assertFalse(actual);
    }

    /**
     * Tests hash codes for equivalent objects.
     */
    @Test
    public void testHash001() {
        MetronomeMarking mm1 = new MetronomeMarking(0, 100);
        MetronomeMarking mm2 = new MetronomeMarking(0, 100);

        assertEquals(mm1.hashCode(), mm2.hashCode());
    }

    /**
     * Tests hash codes for different objects.
     */
    @Test
    public void testHash002() {
        MetronomeMarking mm1 = new MetronomeMarking(0, 100);
        MetronomeMarking mm2 = new MetronomeMarking(0, 120);

        assertNotEquals(mm1.hashCode(), mm2.hashCode());
    }
}