package com.drkharma.vmf;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a piece of music.
 */
public class VectorMusic {

    /**
     * The header of the VMF file.
     */
    private VectorMusicHeader header;

    /**
     * The notes which are part of this piece of music.
     */
    private List<Note> notes;

    /**
     * Default Constructor.
     */
    public VectorMusic() {
        this.header = new VectorMusicHeader();
        this.notes = new LinkedList<Note>();
    }

    /**
     * Constructor allowing provided values.
     *
     * @param header The header of the file.
     * @param notes The body of the file.
     */
    public VectorMusic(VectorMusicHeader header, List<Note> notes) {
        this.header = header;
        this.notes = notes;
    }

    /**
     * Gets the VMF file header.
     * @return The VMF file header.
     */
    public VectorMusicHeader getHeader() {
        return this.header;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VectorMusic that = (VectorMusic) o;

        if (header != null ? !header.equals(that.header) : that.header != null) return false;

        return !(notes != null ? !notes.equals(that.notes) : that.notes != null);
    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);

        return result;
    }
}
