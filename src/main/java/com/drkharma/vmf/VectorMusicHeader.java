package com.drkharma.vmf;

import org.apache.commons.lang3.math.Fraction;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * The header of a VMF file.
 */
public class VectorMusicHeader {

    /**
     * The unique ID of this piece.
     */
    private UUID id;

    /**
     * The name of this piece.
     */
    private String name;

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
     * A piece of music is divided into multiple parts (instruments) which can further be broken down int
     * multiple voices (ex. Left hand and Right hand of the piano).
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
     * The metronome markings in this piece.
     */
    private List<MetronomeMarking> metronomeMarkings;

    /**
     * Default constructor.
     */
    public VectorMusicHeader() {
        this("");
    }

    /**
     * Instantiates an empty piece.
     *
     * @param name The name of this piece.
     */
    public VectorMusicHeader(String name) {
        this.id = UUID.randomUUID();
        this.name = name;

        this.timeSignatures = new LinkedList<TimeSignature>();
        this.keySignatures = new LinkedList<KeySignatureInstance>();
        this.metronomeMarkings = new LinkedList<MetronomeMarking>();
    }

    /**
     * Constructor for providing initial values.
     *
     * @param tickValue         The value of a tick expressed as a fraction of a quarter note.
     * @param numberOfParts     The number of parts in this piece of music.
     * @param numberOfVoices    The number of individual voices in this piece of music.
     * @param name              The name of this piece.
     * @param timeSignatures    The time signatures which are part of this piece.
     * @param keySignatures     The key signatures which are part of this piece.
     * @param metronomeMarkings The metronome markings which are part of this piece.
     */
    public VectorMusicHeader(Fraction tickValue, int numberOfParts, int numberOfVoices, String name,
                             List<TimeSignature> timeSignatures, List<KeySignatureInstance> keySignatures,
                             List<MetronomeMarking> metronomeMarkings) {
        this.id = UUID.randomUUID();
        this.name = name;

        this.tickValue = tickValue;
        this.numberOfParts = numberOfParts;
        this.numberOfVoices = numberOfVoices;
        this.timeSignatures = timeSignatures;
        this.keySignatures = keySignatures;
        this.metronomeMarkings = metronomeMarkings;
    }

    /**
     * Constructor for providing initial values.
     *
     * @param tickValue         The value of a tick expressed as a fraction of a quarter note.
     * @param numberOfParts     The number of parts in this piece of music.
     * @param numberOfVoices    The number of individual voices in this piece of music.
     * @param timeSignatures    The time signatures which are part of this piece.
     * @param keySignatures     The key signatures which are part of this piece.
     * @param metronomeMarkings The metronome markings which are part of this piece.
     */
    public VectorMusicHeader(Fraction tickValue, int numberOfParts, int numberOfVoices,
                             List<TimeSignature> timeSignatures, List<KeySignatureInstance> keySignatures,
                             List<MetronomeMarking> metronomeMarkings) {
        this(tickValue, numberOfParts, numberOfVoices, "", timeSignatures, keySignatures, metronomeMarkings);
    }

    /**
     * Gets the ID of this piece.
     *
     * @return The ID of this piece.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the name of this piece.
     *
     * @return The name of this piece.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this piece.
     *
     * @param name The name of this piece.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of a single tick as a fraction of a quarter note.
     *
     * @return The value of a single tick as a fraction of a quarter note.
     */
    public Fraction getTickValue() {
        return tickValue;
    }

    /**
     * Sets the value of a single tick as a fraction of a quarter note.
     *
     * @param tickValue The value of a single tick as a fraction of a quarter note.
     */
    public void setTickValue(Fraction tickValue) {
        this.tickValue = tickValue;
    }

    /**
     * Gets the number of voices.
     *
     * @return The number of voices.
     */
    public int getNumberOfVoices() {
        return numberOfVoices;
    }

    /**
     * Sets the number of voices.
     *
     * @param numberOfVoices The number of voices.
     */
    public void setNumberOfVoices(int numberOfVoices) {
        this.numberOfVoices = numberOfVoices;
    }

    /**
     * Gets the number of independent parts.
     *
     * @return The number of independent parts.
     */
    public int getNumberOfParts() {
        return numberOfParts;
    }

    /**
     * Sets the number of independent parts.
     *
     * @param numberOfParts The number of independent parts.
     */
    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    /**
     * Gets the time signatures in this piece.
     *
     * @return The time signatures in this piece.
     */
    public List<TimeSignature> getTimeSignatures() {
        return timeSignatures;
    }

    /**
     * Sets the time signatures in this piece
     *
     * @param timeSignatures The time signatures in this piece.
     */
    public void setTimeSignatures(List<TimeSignature> timeSignatures) {
        this.timeSignatures = timeSignatures;
    }

    /**
     * Adds a time signature to this piece.
     *
     * @param timeSignature The time signature to add to this piece.
     */
    public void addTimeSignature(TimeSignature timeSignature) {
        this.timeSignatures.add(timeSignature);
    }

    /**
     * Gets the key signatures in this piece.
     *
     * @return The key signatures in this piece.
     */
    public List<KeySignatureInstance> getKeySignatures() {
        return keySignatures;
    }

    /**
     * Sets the key signatures in this piece.
     *
     * @param keySignatures The key signatures in this piece.
     */
    public void setKeySignatures(List<KeySignatureInstance> keySignatures) {
        this.keySignatures = keySignatures;
    }


    /**
     * Adds a key signature to this piece.
     *
     * @param keySignatureInstance The key signature to add to this piece.
     */
    public void addKeySignature(KeySignatureInstance keySignatureInstance) {
        this.keySignatures.add(keySignatureInstance);
    }

    /**
     * Gets the metronome markings in this piece.
     *
     * @return The metronome markings in this piece.
     */
    public List<MetronomeMarking> getMetronomeMarkings() {
        return metronomeMarkings;
    }

    /**
     * Sets the metronome markings in this piece.
     *
     * @param metronomeMarkings The metronome markings in this piece.
     */
    public void setMetronomeMarkings(List<MetronomeMarking> metronomeMarkings) {
        this.metronomeMarkings = metronomeMarkings;
    }

    /**
     * Adds a metronome marking to this piece.
     *
     * @param tempo The metronome marking to add.
     */
    public void addMetronomeMarking(MetronomeMarking tempo) {
        this.metronomeMarkings.add(tempo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VectorMusicHeader that = (VectorMusicHeader) o;

        if (numberOfParts != that.numberOfParts) return false;
        if (numberOfVoices != that.numberOfVoices) return false;
        if (tickValue != null ? !tickValue.equals(that.tickValue) : that.tickValue != null) return false;
        if (timeSignatures != null ? !timeSignatures.equals(that.timeSignatures) : that.timeSignatures != null)
            return false;
        if (keySignatures != null ? !keySignatures.equals(that.keySignatures) : that.keySignatures != null)
            return false;

        return !(metronomeMarkings != null ? !metronomeMarkings.equals(that.metronomeMarkings) : that.metronomeMarkings != null);

    }

    @Override
    public int hashCode() {
        int result = tickValue != null ? tickValue.hashCode() : 0;
        result = 31 * result + numberOfParts;
        result = 31 * result + numberOfVoices;
        result = 31 * result + (timeSignatures != null ? timeSignatures.hashCode() : 0);
        result = 31 * result + (keySignatures != null ? keySignatures.hashCode() : 0);
        result = 31 * result + (metronomeMarkings != null ? metronomeMarkings.hashCode() : 0);

        return result;
    }
}
