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
        this.dynamic = Dynamic.getDynamic(dynamic);
        this.articulation = Articulation.getArticulation(articulation);
        this.pitchClass = PitchClass.getPitchClass(pitchClass);
        this.octave = octave;

        this.duration = 1;
        this.offset = offset;
    }

    /**
     * Extends the duration of this note by a single tick.
     */
    public void incrementDuration() {
        this.duration++;
    }
}
