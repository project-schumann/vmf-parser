package com.drkharma.vmf.parser;

import com.drkharma.vmf.KeySignature;
import com.drkharma.vmf.KeySignatureInstance;
import com.drkharma.vmf.TimeSignature;
import com.drkharma.vmf.VectorMusic;
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
        VectorMusic expected = new VectorMusic(Fraction.ONE, 1, 1,
                Arrays.asList(new TimeSignature(0, "2/4")), Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)));

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
     * Tests the parsing of a VMF file where a header value is misisng.
     */
    @Test(expected = IOException.class)
    public void testParse003() throws IOException {
        final String SIMPLE_VMF = "fixtures/missingHeaderValue.vmf";
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
        VectorMusic expected = new VectorMusic(Fraction.ONE, 1, 1,
                Arrays.asList(new TimeSignature(0, "2/4")), Arrays.asList(new KeySignatureInstance(0, KeySignature.C_MAJOR_A_MINOR)));

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
}