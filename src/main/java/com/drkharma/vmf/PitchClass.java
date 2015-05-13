package com.drkharma.vmf;

import java.util.HashMap;

/**
 * Represents a Pitch Class.
 */
public enum PitchClass {
    C(0),
    C_SHARP(1),
    D(2),
    D_SHARP(3),
    E(4),
    F(5),
    F_SHARP(6),
    G(7),
    G_SHARP(8),
    A(9),
    A_SHARP(10),
    B(11);

    /**
     * A lookup table allowing the enum to be searched by the VMF
     * pitch class code.
     */
    private static HashMap<Integer, PitchClass> pitchClassLookup;
    /**
     * The VMF code of this pitch class.
     */
    private int pitchClassCode;

    /**
     * Constructor.
     *
     * @param pitchClassCode The pitch class code in VMF corresponding to this pitch class.
     */
    PitchClass(int pitchClassCode) {
        this.pitchClassCode = pitchClassCode;

        this.registerPitchClass();
    }

    /**
     * Looks up the pitch class by the VMF code.
     *
     * @param pitchClassCode The VMF code.
     * @return The {@link PitchClass} which corresponds to this code.
     * @throws IllegalArgumentException If the code provided is negative or greater than 11.
     */
    public static PitchClass getPitchClass(int pitchClassCode) {
        if (pitchClassCode < 0 || pitchClassCode > 11) {
            throw new IllegalArgumentException("The code should be between 0 and 11 inclusive.");
        }

        return pitchClassLookup.get(pitchClassCode);
    }

    /**
     * Gets the VMF code of this pitch class.
     *
     * @return The VMF code of this pitch class.
     */
    public int getPitchClassCode() {
        return pitchClassCode;
    }

    /**
     * Registers a pitch class in the lookup table.
     */
    private void registerPitchClass() {
        if (pitchClassLookup == null) {
            pitchClassLookup = new HashMap<Integer, PitchClass>();
        }

        pitchClassLookup.put(this.pitchClassCode, this);
    }
}
