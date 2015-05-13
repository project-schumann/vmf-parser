package com.drkharma.vmf;

import org.apache.commons.lang3.math.Fraction;

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
    private List<TimeSignature> timeSignatures = new LinkedList<TimeSignature>();

    /**
     * The key signatures which are part of this piece.
     */
    private List<KeySignatureInstance> keySignatures = new LinkedList<KeySignatureInstance>();

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
}
