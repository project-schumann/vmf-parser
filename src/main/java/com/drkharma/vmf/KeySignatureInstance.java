package com.drkharma.vmf;

/**
 * An instance of a KeySignature at a specific location in the piece.
 */
public class KeySignatureInstance {

    /**
     * The KeySignature represented by this instance.
     */
    private final KeySignature keySignature;

    /**
     * The measure at which this time signature is placed.
     */
    private final int measure;

    /**
     * Constructor
     *
     * @param measure      The measure at which this time signature is placed.
     * @param keySignature The time signature at the location specified by {@code measure}.
     */
    public KeySignatureInstance(int measure, KeySignature keySignature) {
        this.measure = measure;
        this.keySignature = keySignature;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(KeySignatureInstance.class)) {
            KeySignatureInstance that = (KeySignatureInstance) obj;

            if (this.keySignature.equals(that.keySignature)
                    && this.measure == that.measure) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        Integer measure = new Integer(this.measure);
        return this.keySignature.hashCode() + measure.hashCode();
    }
}
