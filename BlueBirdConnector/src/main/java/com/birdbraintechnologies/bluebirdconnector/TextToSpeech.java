package com.birdbraintechnologies.bluebirdconnector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

import static com.birdbraintechnologies.bluebirdconnector.Utilities.stackTraceToString;

//https://www.geeksforgeeks.org/converting-text-speech-java/
//https://freetts.sourceforge.io/

//TODO: Try mbrola voices
//https://stackoverflow.com/questions/26236562/mbrola-voices-with-freetts-windows
//https://github.com/numediart/MBROLA

public class TextToSpeech {
    Synthesizer synthesizer = null;
    static final Logger LOG = LoggerFactory.getLogger(TextToSpeech.class);

    public TextToSpeech(String text) {
        try {
            // Set property as Kevin Dictionary
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

            // Register Engine
            Central.registerEngineCentral(
                    "com.sun.speech.freetts"
                            + ".jsapi.FreeTTSEngineCentral");

            // Create a Synthesizer
            synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

            // Allocate synthesizer
            synthesizer.allocate();

            this.say(text);

        } catch (Exception e) {
            LOG.error("TTS startup error: {}; {}", e.getMessage(), stackTraceToString(e));
        }
    }

    public void say (String text) {
        try {
            // Resume Synthesizer
            synthesizer.resume();

            // Speaks the given text
            // until the queue is empty.
            synthesizer.speakPlainText(text, null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

        } catch (Exception e) {
            LOG.error("TTS error: {}; {}", e.getMessage(), stackTraceToString(e));
        }
    }

    public void close() {
        LOG.info("Releasing the tts synthesizer...");
        try {
            // Deallocate the Synthesizer.
            synthesizer.deallocate();
        } catch (Exception e) {
            LOG.error("TTS cleanup error: {}; {}", e.getMessage(), stackTraceToString(e));
        }
    }
}