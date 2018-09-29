package com.tele2.jurikolo.springbootbook.spamdetection.impl.fs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tele2.jurikolo.springbootbook.spamdetection.SpamDetector;
import com.tele2.jurikolo.springbootbook.spamdetection.impl.SimpleSpamDetector;

public class SimpleSpamDetectorTest {

    @Test
    public void testSpamTrue() throws Exception {
        SpamDetector spamDetector = new SimpleSpamDetector("/words.spam");
        
        assertTrue(spamDetector.containsSpam("I LOVE VIAGRA"));
        assertTrue(spamDetector.containsSpam("Horst Fuck"));
        assertTrue(spamDetector.containsSpam("Hort@horst-porn.com"));
    }

    @Test
    public void testSpamFalse() throws Exception {
        SpamDetector spamDetector = new SimpleSpamDetector("/words.spam");
        
        assertFalse(spamDetector.containsSpam("I LOVE Dogs"));
        assertFalse(spamDetector.containsSpam("I LOVE Robots"));
        assertFalse(spamDetector.containsSpam("I LOVE Cats"));
    }

}
