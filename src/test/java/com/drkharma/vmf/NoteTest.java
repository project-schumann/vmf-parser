package com.drkharma.vmf;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class for {@link Note}
 */
public class NoteTest {

    /**
     * Tests to ensure that a note duration is properly incremented.
     */
    @Test
    public void testIncrementDuration001() {
        Note note = new Note(3, 0, 0, 4, 0);

        int expected = note.getDuration() + 1;

        note.incrementDuration();

        int actual = note.getDuration();

        assertEquals(expected, actual);
    }

    /**
     * Test equality check for an equivalent object.
     */
    @Test
    public void testEquals001() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-1, 0, 0, 4, 0);

        boolean actual = note1.equals(note2);

        assertTrue(actual);
    }

    /**
     * Equality check with a null object.
     */
    @Test
    public void testEquals002() {
        Note note1 = new Note(-1, 0, 0, 4, 0);

        boolean actual = note1.equals(null);

        assertFalse(actual);
    }

    /**
     * Equality check with an object of a different type.
     */
    @Test
    public void testEquals003() {
        Note note1 = new Note(-1, 0, 0, 4, 0);

        boolean actual = note1.equals("hello world");

        assertFalse(actual);
    }

    /**
     * Test equality check with different dynamic.
     */
    @Test
    public void testEquals004() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-2, 0, 0, 4, 0);

        boolean actual = note1.equals(note2);

        assertFalse(actual);
    }

    /**
     * Test equality check with different articulation.
     */
    @Test
    public void testEquals005() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-1, 3, 0, 4, 0);

        boolean actual = note1.equals(note2);

        assertFalse(actual);
    }

    /**
     * Test equality check with different pitch class.
     */
    @Test
    public void testEquals006() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-1, 0, 2, 4, 0);

        boolean actual = note1.equals(note2);

        assertFalse(actual);
    }

    /**
     * Test equality check with different octave..
     */
    @Test
    public void testEquals007() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-1, 0, 0, 5, 0);

        boolean actual = note1.equals(note2);

        assertFalse(actual);
    }

    /**
     * Test equality check with different duration..
     */
    @Test
    public void testEquals008() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-1, 0, 0, 4, 0, 2);

        boolean actual = note1.equals(note2);

        assertFalse(actual);
    }

    /**
     * Test equality check with different offset..
     */
    @Test
    public void testEquals009() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-1, 0, 0, 4, 1);

        boolean actual = note1.equals(note2);

        assertFalse(actual);
    }

    /**
     * Tests hash codes for equivalent objects.
     */
    @Test
    public void testHash001() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-1, 0, 0, 4, 0);

        assertEquals(note1.hashCode(), note2.hashCode());
    }

    /**
     * Tests hash codes for different objects.
     */
    @Test
    public void testHash002() {
        Note note1 = new Note(-1, 0, 0, 4, 0);
        Note note2 = new Note(-1, 0, 0, 5, 0);

        assertNotEquals(note1.hashCode(), note2.hashCode());
    }
}