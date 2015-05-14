package com.drkharma.vmf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link PitchClass}
 */
public class PitchClassTest {

    /**
     * Tests Pitch Class look up for a valid code.
     */
    @Test
    public void testGetPitchClass001() {
        PitchClass actual = PitchClass.getPitchClass(0);

        assertEquals(PitchClass.C, actual);
    }

    /**
     * Tests Pitch Class look up for a negative code.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetPitchClass002() {
        PitchClass actual = PitchClass.getPitchClass(-10);
    }

    /**
     * Tests Pitch Class look up for a code greater than 11.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetPitchClass003() {
        PitchClass actual = PitchClass.getPitchClass(13);
    }

    /**
     * Tests retrieval of a pitch class code.
     */
    @Test
    public void testGetPitchClassCode001() {
        int code = PitchClass.C.getPitchClassCode();

        assertEquals(0, code);
    }
}