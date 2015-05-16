package com.drkharma.vmf;

import org.apache.commons.lang3.math.Fraction;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a piece of music.
 */
public class VectorMusic {

    /**
     * The value of a tick expressed as a fraction of a quarter note.
     */
    private Fraction tickValue;

    /**
     * The number of parts in this piece of music.
     */
    private int numberOfParts;

    /**
     * The number of individual voices in this piece of music.
     * <p/>
     * <p>
     * A piece of music is divided into multiple parts (instruments) which can further be broken down int
     * multiple voices (ex. Left hand and Right hand of the piano).
     * </p>
     */
    private int numberOfVoices;

    /**
     * The time signatures which are part of this piece.
     */
    private List<TimeSignature> timeSignatures;

    /**
     * The key signatures which are part of this piece.
     */
    private List<KeySignatureInstance> keySignatures;

    /**
     * The notes which are part of this piece of music.
     */
    private List<Note> notes;

    /**
     * The metronome markings in this piece.
     */
    private List<MetronomeMarking> metronomeMarkings;

    /**
     * Default Constructor.
     */
    public VectorMusic() {
        this.timeSignatures = new LinkedList<TimeSignature>();
        this.keySignatures = new LinkedList<KeySignatureInstance>();
        this.notes = new LinkedList<Note>();
        this.metronomeMarkings = new LinkedList<MetronomeMarking>();
    }

    /**
     * Constructor allowing provided values.
     *
     * @param tickValue      The value of a tick expressed as a fraction of a quarter note.
     * @param numberOfParts  The number of parts in this piece of music.
     * @param numberOfVoices The number of individual voices in this piece of music.
     * @param timeSignatures The time signatures which are part of this piece.
     * @param keySignatures  The key signatures which are part of this piece.
     */
    public VectorMusic(Fraction tickValue, int numberOfParts, int numberOfVoices,
                       List<TimeSignature> timeSignatures, List<KeySignatureInstance> keySignatures,
                       List<Note> notes, List<MetronomeMarking> tempi) {
        this.tickValue = tickValue;
        this.numberOfParts = numberOfParts;
        this.numberOfVoices = numberOfVoices;
        this.timeSignatures = timeSignatures;
        this.keySignatures = keySignatures;
        this.notes = notes;
        this.metronomeMarkings = tempi;
    }

    /**
     * Gets the value of a tick expressed as a fraction of a quarter note.
     *
     * @return The value of a tick expressed as a fraction of a quarter note.
     */
    public Fraction getTickValue() {
        return tickValue;
    }

    /**
     * Sets the tickValue field.
     *
     * @param tickValue The value of a tick expressed as a fraction of a quarter note.
     */
    public void setTickValue(Fraction tickValue) {
        this.tickValue = tickValue;
    }

    /**
     * Sets the numberOfParts field.
     *
     * @param numberOfParts The number of individual parts in this piece of music.
     */
    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    /**
     * Sets the numberOfVoices field.
     *
     * @param numberOfVoices The number of individual voice sin this piece of music.
     */
    public void setNumberOfVoices(int numberOfVoices) {
        this.numberOfVoices = numberOfVoices;
    }

    /**
     * Adds a time signature to this piece.
     *
     * @param timeSignature The time signature to add.
     */
    public void addTimeSignature(TimeSignature timeSignature) {
        this.timeSignatures.add(timeSignature);
    }

    /**
     * Adds a key signature to this piece.
     *
     * @param keySignature The key signature to add.
     */
    public void addKeySignature(KeySignatureInstance keySignature) {
        this.keySignatures.add(keySignature);
    }

    /**
     * Adds a note to this piece.
     *
     * @param note The note to add.
     */
    public void addNote(Note note) {
        this.notes.add(note);
    }

    /**
     * Gets a read-only view of the notes in this piece.
     * @return The notes in this piece.
     */
    public List<Note> getNotes() {
        return Collections.unmodifiableList(this.notes);
    }

    /**
     * Adds a metronomome marking to this peice.
     *
     * @param tempo The metronome marking to add.
     */
    public void addMetronomeMarking(MetronomeMarking tempo) {
        this.metronomeMarkings.add(tempo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(VectorMusic.class)) {
            VectorMusic that = (VectorMusic) obj;

            if (this.tickValue.equals(that.tickValue)
                    && this.numberOfParts == that.numberOfParts
                    && this.numberOfVoices == that.numberOfVoices
                    && this.timeSignatures.equals(that.timeSignatures)
                    && this.keySignatures.equals(that.keySignatures)
                    && this.notes.equals(that.notes)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        Integer numberOfParts = new Integer(this.numberOfParts);
        Integer numberOfVoices = new Integer(this.numberOfVoices);

        return this.tickValue.hashCode() + numberOfParts.hashCode() + numberOfVoices.hashCode()
                + this.timeSignatures.hashCode() + this.keySignatures.hashCode();
    }
}
