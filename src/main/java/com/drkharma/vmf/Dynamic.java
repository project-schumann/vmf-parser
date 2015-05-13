package com.drkharma.vmf;

import java.util.HashMap;

/**
 * Represents a dynamic level.
 */
public enum Dynamic {
    PPPP(-5),
    PPP(-4),
    PP(-3),
    P(-2),
    MP(-1),
    MF(1),
    F(2),
    FF(3),
    FFF(4),
    FFFF(5);

    /**
     * A lookup table allowing the enum to be searched by the VMF
     * articulation code.
     */
    private static HashMap<Integer, Dynamic> dynamicLookup;
    /**
     * The VMF code of this dynamic.
     */
    private int dynamicCode;

    /**
     * Constructor.
     *
     * @param dynamicCode The dynamic code in VMF corresponding to this dynamic level.
     */
    Dynamic(int dynamicCode) {
        this.dynamicCode = dynamicCode;

        this.registerDynamic();
    }

    /**
     * Looks up the dynamic by the VMF code.
     *
     * @param dynamicCode The VMF code.
     * @return The {@link Dynamic} which corresponds to this code.
     * @throws IllegalArgumentException If the code provided is greater than 5 or less than -5, or 0.
     */
    public static Dynamic getDynamic(int dynamicCode) throws IllegalArgumentException {
        if (Math.abs(dynamicCode) > 5 || dynamicCode == 0) {
            throw new IllegalArgumentException("The code should be between -5 and 5, but not 0");
        }

        return dynamicLookup.get(dynamicCode);
    }

    /**
     * Gets the VMF code of this dynamic.
     *
     * @return The VMF code of this dynamic.
     */
    public int getDynamicCode() {
        return dynamicCode;
    }

    /**
     * Registers a Dynamic in the lookup table.
     */
    private void registerDynamic() {
        if (dynamicLookup == null) {
            dynamicLookup = new HashMap<Integer, Dynamic>();
        }

        dynamicLookup.put(this.dynamicCode, this);
    }
}
