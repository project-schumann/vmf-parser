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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetronomeMarking that = (MetronomeMarking) o;

        if (measure != that.measure) return false;
        return quarterBPM == that.quarterBPM;

    }

    @Override
    public int hashCode() {
        int result = measure;
        result = 31 * result + quarterBPM;
        return result;
    }
}
