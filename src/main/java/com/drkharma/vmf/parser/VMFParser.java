package com.drkharma.vmf.parser;

import com.drkharma.vmf.KeySignature;
import com.drkharma.vmf.KeySignatureInstance;
import com.drkharma.vmf.TimeSignature;
import com.drkharma.vmf.VectorMusic;
import com.drkharma.vmf.parser.exception.TimeSignatureMissingException;
import org.apache.commons.lang3.math.Fraction;
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

        Iterator<String> tsIt = timeSignatures.keys();
        Iterator<String> ksIt = keySignatures.keys();

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
    }
}
