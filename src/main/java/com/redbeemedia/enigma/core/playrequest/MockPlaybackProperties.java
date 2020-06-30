package com.redbeemedia.enigma.core.playrequest;

import com.redbeemedia.enigma.core.format.IMediaFormatPreferenceSpec;

public class MockPlaybackProperties implements IPlaybackProperties {
    @Override
    public PlayFrom getPlayFrom() {
        return PlayFrom.PLAYER_DEFAULT;
    }

    @Override
    public IMediaFormatPreferenceSpec getMediaFormatPreferences() {
        return null;
    }
}
