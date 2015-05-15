package com.drkharma.vmf;

/**
 * Represents a metronome marking in a score in BPM at a specific location.
 */
public class MetronomeMarking {

    /**
     * The measure where this marking is located,
     */
    private final int measure;

    /**
     * The tempo of this marking.
     */
    private final int quarterBPM;

    /**
     * Creates a new Metronome Marking at the provided tempo and measure.
     *
     * @param measure    The measure where this marking is located.
     * @param quarterBPM The tempo this marking represents in BPM.
     */
    public MetronomeMarking(int measure, int quarterBPM) {
        this.measure = measure;
        this.quarterBPM = quarterBPM;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(MetronomeMarking.class)) {
            MetronomeMarking that = (MetronomeMarking) obj;

            if (this.measure == that.measure
                    && this.quarterBPM == that.quarterBPM) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        Integer measure = new Integer(this.measure);
        Integer quarterBPM = new Integer(this.quarterBPM);

        return measure.hashCode() + quarterBPM.hashCode();
    }
}
