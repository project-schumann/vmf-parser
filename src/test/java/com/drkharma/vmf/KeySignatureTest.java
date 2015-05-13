package com.drkharma.vmf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link KeySignature}
 */
public class KeySignatureTest {

    /**
     * Tests the case where a key signature has 0 sharps and 0
     * flats.
     */
    @Test
    public void testGetKeySignatureCode001() {
        int code = KeySignature.C_MAJOR_A_MINOR.getKeySignatureCode();

        assertEquals(0, code);
    }

    /**
     * Tests the case where a key signature has sharps.
     */
    @Test
    public void testGetKeySignatureCode002() {
        int code = KeySignature.G_MAJOR_E_MINOR.getKeySignatureCode();

        assertEquals(1, code);
    }

    /**
     * Tests the case where a key signature has flats.
     */
    @Test
    public void testGetKeySignature003() {
        int code = KeySignature.F_MAJOR_D_MINOR.getKeySignatureCode();

        assertEquals(-1, code);
    }


    /**
     * Tests retrieval of a key signature which exists.
     */
    @Test
    public void testGetKeySignature001() {
        KeySignature ks = KeySignature.getKeySignature(0);

        assertEquals(KeySignature.C_MAJOR_A_MINOR, ks);
    }

    /**
     * Tests retrieval of a key signature which does not exist.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetKeySignature002() {
        KeySignature ks = KeySignature.getKeySignature(100);
    }
}