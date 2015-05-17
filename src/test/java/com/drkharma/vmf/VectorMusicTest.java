package com.drkharma.vmf;

import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test Class for {@link VectorMusic}
 */
public class VectorMusicTest {

    /**
     * Tests equality check with a valid object.
     */
    @Test
    public void testEquals001() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))
                ),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(vm2);

        assertTrue(actual);
    }

    /**
     * Equality test with a null object.
     */
    @Test
    public void testEquals002() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(null);

        assertFalse(actual);
    }

    /**
     * Equality test with an object of a different class,
     */
    @Test
    public void testEquals003() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))
                ),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals("hello world.");

        assertFalse(actual);
    }

    /**
     * Equality test with different tick value.
     */
    @Test
    public void testEquals004() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE_HALF, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(vm2);

        assertFalse(false);
    }

    /**
     * Equality test with different number of parts.
     */
    @Test
    public void testEquals005() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 2, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(vm2);

        assertFalse(false);
    }

    /**
     * Equality test with different number of voices.
     */
    @Test
    public void testEquals006() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 2,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(vm2);

        assertFalse(false);
    }

    /**
     * Equality test with different time signatures.
     */
    @Test
    public void testEquals007() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "4/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(vm2);

        assertFalse(false);
    }

    /**
     * Equality test with different key signatures.
     */
    @Test
    public void testEquals008() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_SHARP_MAJOR_A_SHARP_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(vm2);

        assertFalse(false);
    }

    /**
     * Equality test with different notes..
     */
    @Test
    public void testEquals009() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 0, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(vm2);

        assertFalse(false);
    }

    /**
     * Equality test with different metronome markings..
     */
    @Test
    public void testEquals010() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 0, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 200))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        boolean actual = vm1.equals(vm2);

        assertFalse(false);
    }

    /**
     * Tests the hash code for two equivalent objects.
     */
    @Test
    public void testHashCode001() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        assertEquals(vm1.hashCode(), vm2.hashCode());
    }

    /**
     * Tests the hash code for two different objects.
     */
    @Test
    public void testHashCode002() {
        VectorMusic vm1 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        VectorMusic vm2 = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "4/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        assertNotEquals(vm1.hashCode(), vm2.hashCode());
    }
}