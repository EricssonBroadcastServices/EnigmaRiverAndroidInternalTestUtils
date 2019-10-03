package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.error.EnigmaError;

public class MockCommunicationsChannel implements IEnigmaPlayerConnection.ICommunicationsChannel {
    @Override
    public void onPlaybackError(EnigmaError error, boolean endStream) {
    }
}
