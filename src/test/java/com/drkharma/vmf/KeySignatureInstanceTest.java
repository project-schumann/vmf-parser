package com.drkharma.vmf;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link KeySignatureInstance}
 */
public class KeySignatureInstanceTest {

    /**
     * Equality test with an equivalent object.
     */
    @Test
    public void testEquals001() {
        KeySignature ks = KeySignature.B_FLAT_MAJOR_G_MINOR;

        KeySignatureInstance ksi1 = new KeySignatureInstance(10, ks);
        KeySignatureInstance ksi2 = new KeySignatureInstance(10, ks);

        boolean actual = ksi1.equals(ksi2);

        assertTrue(actual);
    }

    /**
     * Equality test with a null object.
     */
    @Test
    public void testEquals002() {
        KeySignature ks = KeySignature.B_FLAT_MAJOR_G_MINOR;

        KeySignatureInstance ksi1 = new KeySignatureInstance(10, ks);

        boolean actual = ksi1.equals(null);

        assertFalse(actual);
    }

    /**
     * Equality test with an object of a different class
     */
    @Test
    public void testEquals003() {
        KeySignature ks = KeySignature.B_FLAT_MAJOR_G_MINOR;

        KeySignatureInstance ksi1 = new KeySignatureInstance(10, ks);

        boolean actual = ksi1.equals(ks);

        assertFalse(actual);
    }

    /**
     * Equality test with an instance with a different offset.
     */
    @Test
    public void testEquals004() {
        KeySignature ks = KeySignature.B_FLAT_MAJOR_G_MINOR;

        KeySignatureInstance ksi1 = new KeySignatureInstance(10, ks);
        KeySignatureInstance ksi2 = new KeySignatureInstance(11, ks);

        boolean actual = ksi1.equals(ksi2);

        assertFalse(actual);
    }

    /**
     * Equality test with an instance with a different signature.
     */
    @Test
    public void testEquals005() {
        KeySignature ks1 = KeySignature.B_FLAT_MAJOR_G_MINOR;
        KeySignature ks2 = KeySignature.A_FLAT_MAJOR_F_MINOR;

        KeySignatureInstance ksi1 = new KeySignatureInstance(10, ks1);
        KeySignatureInstance ksi2 = new KeySignatureInstance(10, ks2);

        boolean actual = ksi1.equals(ksi2);

        assertFalse(actual);
    }

    /**
     * Tests the hash code for two equivalent objects.
     */
    @Test
    public void testHashCode001() {
        KeySignature ks = KeySignature.B_FLAT_MAJOR_G_MINOR;

        KeySignatureInstance ksi1 = new KeySignatureInstance(10, ks);
        KeySignatureInstance ksi2 = new KeySignatureInstance(10, ks);

        assertEquals(ksi1.hashCode(), ksi2.hashCode());
    }

    /**
     * Tests the hash code for two different objects.
     */
    @Test
    public void testHashCode002() {
        KeySignature ks1 = KeySignature.B_FLAT_MAJOR_G_MINOR;
        KeySignature ks2 = KeySignature.A_FLAT_MAJOR_F_MINOR;

        KeySignatureInstance ksi1 = new KeySignatureInstance(10, ks1);
        KeySignatureInstance ksi2 = new KeySignatureInstance(10, ks2);

        assertNotEquals(ksi1.hashCode(), ksi2.hashCode());
    }
}