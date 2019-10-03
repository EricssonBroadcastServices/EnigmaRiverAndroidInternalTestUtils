package com.redbeemedia.enigma.core.playrequest;

import com.redbeemedia.enigma.core.error.EnigmaError;
import com.redbeemedia.enigma.core.playbacksession.IPlaybackSession;

import org.junit.Assert;

public class MockPlayResultHandler extends BasePlayResultHandler {
    @Override
    public void onStarted(IPlaybackSession playbackSession) {
    }

    @Override
    public void onError(EnigmaError error) {
        error.printStackTrace();
        Assert.fail(error.getClass().getSimpleName());
    }
}
