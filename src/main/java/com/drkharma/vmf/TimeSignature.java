package com.drkharma.vmf;

/**
 * An instance of a Time Signature at a specific location in the piece.
 */
public class TimeSignature {

    /**
     * The measure at which this time signature is placed.
     */
    private final int measure;

    /**
     * The upper value of the time signature, the number of units in a measure.
     */
    private final int upper;

    /**
     * The lower value of the time signature, the value of a singal unit.
     */
    private final int lower;

    /**
     * Constructor
     *
     * @param measure The measure at which this key signature is placed.
     * @param strRepr The time signature at the location specified by {@code measure} represented
     *                as a string. (eg. "4/4").
     */
    public TimeSignature(int measure, String strRepr) {
        String[] parts = strRepr.split("/");

        this.upper = Integer.parseInt(parts[0]);
        this.lower = Integer.parseInt(parts[1]);
        this.measure = measure;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(TimeSignature.class)) {
            TimeSignature that = (TimeSignature) obj;

            if (this.measure == that.measure
                    && this.upper == that.upper
                    && this.lower == that.lower) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        Integer measure = new Integer(this.measure);
        Integer upper = new Integer(this.upper);
        Integer lower = new Integer(this.lower);

        return measure.hashCode() + upper.hashCode() + lower.hashCode();
    }
}