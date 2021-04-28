package com.redbeemedia.enigma.core.playrequest;

import com.redbeemedia.enigma.core.format.IMediaFormatSelector;

public class MockPlaybackProperties implements IPlaybackProperties {
    @Override
    public PlayFrom getPlayFrom() {
        return PlayFrom.PLAYER_DEFAULT;
    }

    @Override
    public IMediaFormatSelector getMediaFormatSelector() {
        return null;
    }

    @Override
    public AdobePrimetime getAdobePrimetime() {
        return null;
    }

    @Override
    public boolean enableAnalytics() { return true; }

}
