package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.error.Error;

public class MockCommunicationsChannel implements IEnigmaPlayerConnection.ICommunicationsChannel {
    @Override
    public void onPlaybackError(Error error, boolean endStream) {
    }
}
