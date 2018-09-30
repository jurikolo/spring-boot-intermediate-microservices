package com.tele2.jurikolo.springbootbook.spamdetection;



/**
 * Interface for detecting spam comments
 *
 */
public interface SpamDetector {

	boolean containsSpam(String value);
}
