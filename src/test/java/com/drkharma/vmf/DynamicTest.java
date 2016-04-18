package com.drkharma.vmf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Dynamic}
 */
public class DynamicTest {

    /**
     * Tests retrieval of a dynamic with a valid code.
     */
    @Test
    public void testGetDynamic001() {
        Dynamic actual = Dynamic.getDynamic(-3);

        assertEquals(Dynamic.PP, actual);
    }

    /**
     * Tests retrieval of a dynamic with code less than -5.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetDynamicCode002() {
        @SuppressWarnings("unused")
		Dynamic actual = Dynamic.getDynamic(-10);
    }

    /**
     * Tests retrieval of a dynamic with a code greater than 5.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetDynamicCode003() {
        @SuppressWarnings("unused")
		Dynamic actual = Dynamic.getDynamic(10);
    }

    /**
     * Tests retrieval of a dynamic with a code of 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetDynamic004() {
        @SuppressWarnings("unused")
		Dynamic actual = Dynamic.getDynamic(0);
    }

    /**
     * Tests retrieval of a dynamic code.
     */
    @Test
    public void testGetDynamicCode001() {
        int code = Dynamic.F.getDynamicCode();

        assertEquals(2, code);
    }
}