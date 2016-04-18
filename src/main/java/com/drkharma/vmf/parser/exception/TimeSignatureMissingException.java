package com.drkharma.vmf.parser.exception;

/**
 * Exception for describing situations where a time signature is missing.
 */
public class TimeSignatureMissingException extends Throwable {
	private static final long serialVersionUID = -3521964037784378865L;

	/**
     * Default Constructor
     */
    public TimeSignatureMissingException() {
    }

    /**
     * Constructor with provided message.
     *
     * @param s The message to return to the catcher.
     */
    public TimeSignatureMissingException(String s) {
        super(s);
    }
}
