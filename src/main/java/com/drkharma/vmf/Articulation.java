package com.drkharma.vmf;

import java.util.HashMap;

/**
 * Represents an articulation.
 */
public enum Articulation {
    NONE(0),
    STACCATO(3),
    STACCATISSIMO(4),
    STRONG_ACCENT(5),
    ACCENT(6),
    TENUTE(7);

    /**
     * A lookup table allowing the enum to be searched by the VMF
     * articulation code.
     */
    private static HashMap<Integer, Articulation> articulationLookup;
    /**
     * The VMF code of this articulation.
     */
    private int articulationCode;

    /**
     * Constructor,
     *
     * @param articulationCode The articulation code in VMF corresponding to this articulation.
     */
    Articulation(int articulationCode) {
        this.articulationCode = articulationCode;

        this.registerArticulation();
    }

    /**
     * Looks up the articulation by the VMF code.
     *
     * @param articulationCode The VMF code.
     * @return The {@link Articulation} which corresponds to this code.
     * @throws IllegalArgumentException If the code provided is less than 3 or greater than 7 and not 0.
     */
    public static Articulation getArticulation(int articulationCode) throws IllegalArgumentException {
        if ((articulationCode < 3 || articulationCode > 7) && articulationCode != 0) {
            throw new IllegalArgumentException("The code should be 0 or between 3 and 7.");
        }

        return articulationLookup.get(articulationCode);
    }

    /**
     * Gets the VMF code of this articulation.
     *
     * @return The VMF code of this articulation.
     */
    public int getArticulationCode() {
        return articulationCode;
    }

    /**
     * Registers an Articulation in the lookup table.
     */
    private void registerArticulation() {
        if (articulationLookup == null) {
            articulationLookup = new HashMap<Integer, Articulation>();
        }

        articulationLookup.put(this.articulationCode, this);
    }
}
