package com.drkharma.vmf;

/**
 * Represents a single note.
 */
public class Note {

    /**
     * The dynamic level of this note.
     */
    private Dynamic dynamic;

    /**
     * The articulation of this note.
     */
    private Articulation articulation;

    /**
     * The pitch class of this note.
     */
    private PitchClass pitchClass;

    /**
     * The octave of this note.
     */
    private int octave;

    /**
     * The duration of this note in ticks.
     */
    private int duration;

    /**
     * The offset of this note from the beginning previous note.
     * If this is the first note in the piece, the offset is from the beginning of the music.
     */
    private int offset;

    /**
     * Builds a Note from VMF codes.
     *
     * @param dynamic      The VMF code for the dynamic.
     * @param articulation The VMF code for the articulation.
     * @param pitchClass   The VMF code for the pitch class.
     * @param octave       The octave of this note.
     * @param offset       The offset from the beginning of the previous note. In the case of the first
     *                     note of the piece, this is from the beginning of the music.
     */
    public Note(int dynamic, int articulation, int pitchClass, int octave, int offset) {
        this(dynamic, articulation, pitchClass, octave, offset, 1);
    }

    /**
     * Builds a Note from VMF codes.
     *
     * @param dynamic      The VMF code for the dynamic.
     * @param articulation The VMF code for the articulation.
     * @param pitchClass   The VMF code for the pitch class.
     * @param octave       The octave of this note.
     * @param offset       The offset from the beginning of the previous note. In the case of the first
     *                     note of the piece, this is from the beginning of the music.
     * @param duration     The duration of the note in ticks.
     */
    public Note(int dynamic, int articulation, int pitchClass, int octave, int offset, int duration) {
        this.dynamic = Dynamic.getDynamic(dynamic);
        this.articulation = Articulation.getArticulation(articulation);
        this.pitchClass = PitchClass.getPitchClass(pitchClass);
        this.octave = octave;

        this.duration = duration;
        this.offset = offset;
    }

    /**
     * Gets the duration of this note in ticks.
     *
     * @return The duration of this note in ticks.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Extends the duration of this note by a single tick.
     */
    public void incrementDuration() {
        this.duration++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(Note.class)) {
            Note that = (Note) obj;

            if (this.dynamic.equals(that.dynamic)
                    && this.articulation.equals(that.articulation)
                    && this.pitchClass.equals(that.pitchClass)
                    && this.octave == that.octave
                    && this.duration == that.duration
                    && this.offset == that.offset) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        Integer octave = new Integer(this.octave);
        Integer duration = new Integer(this.duration);
        Integer offset = new Integer(this.offset);

        return this.dynamic.hashCode() + this.articulation.hashCode()
                + this.pitchClass.hashCode() + octave.hashCode()
                + duration.hashCode() + offset.hashCode();
    }
}
