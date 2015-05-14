package com.drkharma.vmf;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for {@link TimeSignature}
 */
public class TimeSignatureTest {

    /**
     * Tests equality check with an equivalent object.
     */
    @Test
    public void testEquals001() {
        TimeSignature ks1 = new TimeSignature(0, "4/4");
        TimeSignature ks2 = new TimeSignature(0, "4/4");

        boolean actual = ks1.equals(ks2);

        assertTrue(actual);
    }

    /**
     * Tests equality check with a null object.
     */
    @Test
    public void testEquals002() {
        TimeSignature ks1 = new TimeSignature(0, "4/4");

        boolean actual = ks1.equals(null);

        assertFalse(actual);
    }

    /**
     * Tests equality with an object of a different class.
     */
    @Test
    public void testEquals003() {
        TimeSignature ks1 = new TimeSignature(0, "4/4");

        boolean actual = ks1.equals("hello world");

        assertFalse(actual);
    }

    /**
     * Tests equality with an object with different upper.
     */
    @Test
    public void testEquals004() {
        TimeSignature ks1 = new TimeSignature(0, "4/4");
        TimeSignature ks2 = new TimeSignature(0, "2/4");

        boolean actual = ks1.equals(ks2);

        assertFalse(actual);
    }

    /**
     * Tests equality with an object with different lower.
     */
    @Test
    public void testEquals005() {
        TimeSignature ks1 = new TimeSignature(0, "4/4");
        TimeSignature ks2 = new TimeSignature(0, "4/2");

        boolean actual = ks1.equals(ks2);

        assertFalse(actual);
    }

    /**
     * Tests equality with an object with a different measure.
     */
    @Test
    public void testEquals006() {
        TimeSignature ks1 = new TimeSignature(4, "4/4");
        TimeSignature ks2 = new TimeSignature(0, "4/4");

        boolean actual = ks1.equals(ks2);

        assertFalse(actual);
    }
}