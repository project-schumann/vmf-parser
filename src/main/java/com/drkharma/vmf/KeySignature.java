package com.drkharma.vmf;

import java.util.HashMap;

/**
 * Representation of a key signature.
 */
public enum KeySignature {
    C_MAJOR_A_MINOR(0, 0),

    G_MAJOR_E_MINOR(1, 0),
    D_MAJOR_B_MINOR(2, 0),
    A_MAJOR_F_SHARP_MINOR(3, 0),
    E_MAJOR_C_SHAPR_MINOR(4, 0),
    B_MAJOR_G_SHARP_MINOR(5, 0),
    F_SHARP_MAJOR_D_SHARP_MINOR(6, 0),
    C_SHARP_MAJOR_A_SHARP_MINOR(7, 0),

    F_MAJOR_D_MINOR(0, 1),
    B_FLAT_MAJOR_G_MINOR(0, 2),
    E_FLAT_MAJOR_C_MINOR(0, 3),
    A_FLAT_MAJOR_F_MINOR(0, 4),
    D_FLAT_MAJOR_B_FLAT_MINOR(0, 5),
    G_FLAT_MAJOR_E_FLAT_MINOR(0, 6),
    C_FLAT_MAJOR_A_FLAT_MINOR(0, 7);

    /**
     * A lookup table allowing the enum to be searched by the VMF
     * key signature code.
     */
    private static HashMap<Integer, KeySignature> keySignatureLookup;

    /**
     * The number of sharps in the key signature.
     */
    private final int sharps;

    /**
     * The number of flats in the key signature.
     */
    private final int flats;

    /**
     * Constructor
     * <p/>
     * <p>
     * Either sharps or flats should be greater than 0, but never both.
     * It is permissible to have both values at 0.
     * </p>
     *
     * @param sharps The number of sharps in the key signature.
     * @param flats  The number of flats in the key signature.
     */
    KeySignature(int sharps, int flats) {
        this.sharps = sharps;
        this.flats = flats;

        this.registerKeySignature();
    }

    /**
     * Looks up the key signature by the VMF key signature code.
     *
     * @param keySignatureCode The VMF key signature code.
     * @return The {@link KeySignature} which corresponds to this code.
     * @throws IllegalArgumentException If the code provided is greater than 7 or less than -7.
     */
    public static KeySignature getKeySignature(int keySignatureCode) throws IllegalArgumentException {
        if (Math.abs(keySignatureCode) > 7) {
            throw new IllegalArgumentException("The code should be between -7 and 7");
        }

        return keySignatureLookup.get(keySignatureCode);
    }

    /**
     * Gets the VMF key signature code.
     *
     * @return The VMF key signature code.
     */
    public int getKeySignatureCode() {
        if (this.flats == 0 && this.sharps == 0) {
            return 0;
        }
        if (this.flats == 0) {
            return this.sharps;
        } else {
            return this.flats * -1;
        }
    }

    /**
     * Registers a KeySignature in the lookup table.
     */
    private void registerKeySignature() {
        if (keySignatureLookup == null) {
            keySignatureLookup = new HashMap<Integer, KeySignature>();
        }

        if (this.flats == 0 && this.sharps == 0) {
            keySignatureLookup.put(0, this);
        } else if (this.flats == 0) {
            keySignatureLookup.put(this.sharps, this);
        } else {
            keySignatureLookup.put(this.flats * -1, this);
        }
    }
}
