package com.drkharma.vmf.parser;

import com.drkharma.vmf.*;
import com.drkharma.vmf.parser.exception.TimeSignatureMissingException;
import org.apache.commons.lang3.math.Fraction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import static java.lang.Double.parseDouble;

/**
 * A parser for mapping VMF files onto a Java object model.
 */
public class VMFParser {

    /**
     * The music contained in the file which is being parsed.
     */
    private VectorMusic music;

    /**
     * The JSON object containing the music to parse.
     */
    private JSONObject jsonObj;

    /**
     * A parser which maps a VMF file onto an equivalent
     * object model.
     *
     * @param vmfFile The VMF file on the file system.
     * @throws IOException If there is an issue reading the file or it does not exist.
     */
    public VMFParser(File vmfFile) throws IOException {
        this.music = new VectorMusic();

        try {
            this.jsonObj = new JSONObject(readFile(vmfFile));
        } catch (JSONException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Reads the contents of a file into a string.
     *
     * @param file The file to read.
     * @return The contents of the file as a string.
     */
    private static String readFile(File file) throws IOException {
        String line;

        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }

    /**
     * Parses the VMF file provided in the constructor.
     *
     * @return An instance of {@link VectorMusic} representing the VMF file.
     * @throws IOException If there is an issue parsing the file.
     * @throws TimeSignatureMissingException When the file contains no time signatures.
     */
    public VectorMusic parse() throws IOException, TimeSignatureMissingException {
        try {
            this.parseHeader();
            this.parseBody();
        } catch (JSONException e) {
            throw new IOException(e.getMessage());
        }

        return this.music;
    }

    /**
     * Parses the header data from the VMF file.
     *
     * @throws JSONException If the file cannot be parsed.
     * @throws TimeSignatureMissingException If the time signatures section of the header is empty.
     */
    @SuppressWarnings("unchecked")
    private void parseHeader() throws JSONException, TimeSignatureMissingException {
        String key;

        JSONObject header = this.jsonObj.getJSONObject("header");
        JSONObject timeSignatures = header.getJSONObject("time_signature");
        JSONObject keySignatures = header.getJSONObject("key_signature");
        JSONObject tempi = header.getJSONObject("tempo");

        Iterator<String> tsIt = timeSignatures.keys();
        Iterator<String> ksIt = keySignatures.keys();
        Iterator<String> tempoIt = tempi.keys();

        this.music.setTickValue(Fraction.getFraction(header.getString("tick_value")));
        this.music.setNumberOfParts(header.getInt("number_of_parts"));
        this.music.setNumberOfVoices(header.getInt("number_of_voices"));

        if (!tsIt.hasNext()) {
            throw new TimeSignatureMissingException("A minimum of one time signature is required.");
        }

        while (tsIt.hasNext()) {
            key = tsIt.next();

            TimeSignature timeSignature = new TimeSignature((int) parseDouble(key), timeSignatures.getString(key));
            this.music.addTimeSignature(timeSignature);
        }

        if (!ksIt.hasNext()) {
            // If there is no key signature, we will assume the key is C major and it is at the beginning
            // of the piece.
            KeySignature keySignature = KeySignature.C_MAJOR_A_MINOR;
            KeySignatureInstance keySignatureInstance = new KeySignatureInstance(0, keySignature);
            this.music.addKeySignature(keySignatureInstance);
        }

        while (ksIt.hasNext()) {
            key = ksIt.next();

            KeySignature keySignature = KeySignature.getKeySignature(keySignatures.getInt(key));
            KeySignatureInstance keySignatureInstance = new KeySignatureInstance((int) parseDouble(key), keySignature);
            this.music.addKeySignature(keySignatureInstance);
        }

        if (!tempoIt.hasNext()) {
            MetronomeMarking tempo = new MetronomeMarking(0, 100);
            this.music.addMetronomeMarking(tempo);
        }

        while (tempoIt.hasNext()) {
            key = tempoIt.next();

            MetronomeMarking tempo = new MetronomeMarking((int) parseDouble(key), tempi.getInt(key));
            this.music.addMetronomeMarking(tempo);
        }
    }

    /**
     * Parses the body from the VMF file.
     */
    private void parseBody() throws JSONException {
        JSONArray body = this.jsonObj.getJSONArray("body");
        Note currentNote = null;
        int currentOffset = 0;

        // Iterate over all ticks and form the notes of the melody.
        for (int i = 0; i < body.length(); ++i) {
            // For now, only monophonic music is supported, we take the first part in each tick.
            JSONArray currentTick = body.getJSONArray(i).getJSONArray(0);

            // Check the first dimension, if it is 1, a new note is attacked.
            if (currentNote == null || currentTick.getInt(0) == 1) {
                currentNote = new Note(currentTick.getInt(1), currentTick.getInt(2), currentTick.getInt(3),
                        currentTick.getInt(4), currentOffset);

                this.music.addNote(currentNote);

                // Reset the offset for the next note.
                currentOffset = 1;
            } else if (currentTick.getInt(0) == 2) {
                currentNote.incrementDuration();
                currentOffset++;
            } else if (currentTick.getInt(0) == 0) {
                currentOffset++;
            }
        }
    }
}
