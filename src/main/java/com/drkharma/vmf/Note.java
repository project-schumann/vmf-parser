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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (octave != note.octave) return false;
        if (duration != note.duration) return false;
        if (offset != note.offset) return false;
        if (dynamic != note.dynamic) return false;
        if (articulation != note.articulation) return false;
        return pitchClass == note.pitchClass;

    }

    @Override
    public int hashCode() {
        int result = dynamic != null ? dynamic.hashCode() : 0;
        result = 31 * result + (articulation != null ? articulation.hashCode() : 0);
        result = 31 * result + (pitchClass != null ? pitchClass.hashCode() : 0);
        result = 31 * result + octave;
        result = 31 * result + duration;
        result = 31 * result + offset;
        return result;
    }
}
