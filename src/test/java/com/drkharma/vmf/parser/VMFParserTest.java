package com.drkharma.vmf.parser;

import com.drkharma.vmf.*;
import com.drkharma.vmf.parser.exception.TimeSignatureMissingException;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test Class for {@link VMFParser}
 */
public class VMFParserTest {

    /**
     * Tests the parsing of a valid VMF file.
     */
    @Test
    public void testParse001() {
        final String SIMPLE_VMF = "fixtures/simple.vmf";
        VectorMusic actual = null;
        VectorMusic expected = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))
                ),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;
        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        try {
            VMFParser parser = new VMFParser(new File(vmfURI));
            actual = parser.parse();
        } catch (TimeSignatureMissingException | IOException e) {
            fail("Unexpected exception was thrown.");
        }

        assertEquals(expected, actual);
    }

    /**
     * Tests the parsing of a VMF file with the header missing.
     */
    @Test(expected = IOException.class)
    public void testParse002() throws IOException {
        final String SIMPLE_VMF = "fixtures/missingHeader.vmf";
        @SuppressWarnings("unused")
		VectorMusic actual = null;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;

        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        VMFParser parser = new VMFParser(new File(vmfURI));
        try {
            actual = parser.parse();
        } catch (TimeSignatureMissingException e) {
            fail("Unexpected exception was thrown.");
        }
    }

    /**
     * Tests the parsing of a VMF file where a header value is missing.
     */
    @Test(expected = IOException.class)
    public void testParse003() throws IOException {
        final String SIMPLE_VMF = "fixtures/missingHeaderValue.vmf";
        @SuppressWarnings("unused")
		VectorMusic actual = null;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;

        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        VMFParser parser = new VMFParser(new File(vmfURI));
        try {
            actual = parser.parse();
        } catch (TimeSignatureMissingException e) {
            fail("Unexpected exception was thrown");
        }
    }

    /**
     * Tests the parsing of a VMF file where the time signatures list is empty.
     */
    @Test(expected = TimeSignatureMissingException.class)
    public void testParse004() throws TimeSignatureMissingException {
        final String SIMPLE_VMF = "fixtures/noTimeSignatures.vmf";
        @SuppressWarnings("unused")
		VectorMusic actual = null;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;

        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        try {
            VMFParser parser = new VMFParser(new File(vmfURI));
            actual = parser.parse();
        } catch (IOException e) {
            fail("Unexpected exception was thrown.");
        }
    }

    /**
     * Tests the parsing of a VMF file where the key signatures list is empty.
     */
    @Test
    public void testParse005() {
        final String SIMPLE_VMF = "fixtures/noKeySignature.vmf";
        VectorMusic actual = null;
        VectorMusic expected = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))
                ),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;

        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        try {
            VMFParser parser = new VMFParser(new File(vmfURI));
            actual = parser.parse();
        } catch (TimeSignatureMissingException | IOException e) {
            fail("Unexpected exception was thrown.");
        }

        assertEquals(expected, actual);
    }

    /**
     * Tests the parsing of a VMF file where the contents are not JSON.
     */
    @Test(expected = IOException.class)
    public void testParse006() throws IOException {
        final String SIMPLE_VMF = "fixtures/notJson.vmf";
        @SuppressWarnings("unused")
		VectorMusic actual = null;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;

        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        try {
            VMFParser parser = new VMFParser(new File(vmfURI));
            actual = parser.parse();
        } catch (TimeSignatureMissingException e) {
            fail("Unexpected exception was thrown.");
        }
    }

    /**
     * Tests the parsing of a valid VMF file with sustained notes.
     */
    @Test
    public void testParse007() {
        final String SIMPLE_VMF = "fixtures/sustained.vmf";
        VectorMusic actual = null;
        VectorMusic expected = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))
                ),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0, 2),
                        new Note(-1, 0, 4, 4, 2, 2),
                        new Note(-1, 0, 7, 4, 2, 2),
                        new Note(-1, 0, 4, 4, 2, 2)
                )
        );

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;
        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        try {
            VMFParser parser = new VMFParser(new File(vmfURI));
            actual = parser.parse();
        } catch (TimeSignatureMissingException | IOException e) {
            fail("Unexpected exception was thrown.");
        }

        assertEquals(expected, actual);
    }

    /**
     * Tests the parsing of a valid VMF file with rests.
     */
    @Test
    public void testParse008() {
        final String SIMPLE_VMF = "fixtures/rest.vmf";
        VectorMusic actual = null;
        VectorMusic expected = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 120))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 7, 4, 2),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;
        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        try {
            VMFParser parser = new VMFParser(new File(vmfURI));
            actual = parser.parse();
        } catch (TimeSignatureMissingException | IOException e) {
            fail("Unexpected exception was thrown.");
        }

        assertEquals(expected, actual);
    }

    /**
     * Tests the parsing of a VMF file where the tempo list is empty.
     */
    @Test
    public void testParse009() {
        final String SIMPLE_VMF = "fixtures/noTempo.vmf";
        VectorMusic actual = null;
        VectorMusic expected = new VectorMusic(
                new VectorMusicHeader(Fraction.ONE, 1, 1,
                        Arrays.asList(new TimeSignature(0, "2/4")),
                        Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)),
                        Arrays.asList(new MetronomeMarking(0, 100))),
                Arrays.asList(
                        new Note(-1, 0, 0, 4, 0),
                        new Note(-1, 0, 4, 4, 1),
                        new Note(-1, 0, 7, 4, 1),
                        new Note(-1, 0, 4, 4, 1)
                )
        );

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI vmfURI = null;

        try {
            vmfURI = classloader.getResource(SIMPLE_VMF).toURI();
        } catch (URISyntaxException e) {
            fail("Fixture file not found.");
        }

        try {
            VMFParser parser = new VMFParser(new File(vmfURI));
            actual = parser.parse();
        } catch (TimeSignatureMissingException | IOException e) {
            fail("Unexpected exception was thrown.");
        }

        assertEquals(expected, actual);
    }
}