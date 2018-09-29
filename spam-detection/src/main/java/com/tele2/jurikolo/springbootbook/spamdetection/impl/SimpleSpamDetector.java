package com.tele2.jurikolo.springbootbook.spamdetection.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.tele2.jurikolo.springbootbook.spamdetection.SpamDetector;

/**
 * Simple Spam Detector - checks for unwanted words.
 * 
 */
public class SimpleSpamDetector implements SpamDetector {

	private List<String> spamWords = new ArrayList<String>();

	public SimpleSpamDetector(String filename) throws IOException {
		this.spamWords = IOUtils.readLines(getClass().getResourceAsStream(filename));
	}

	@Override
	public boolean containsSpam(String value) {

		for (String spam : spamWords) {
			if (value.toLowerCase().contains(spam)) {
				return true;
			}
		}
		return false;
	}

}
