package com.redbeemedia.enigma.core.subtitle;

import com.redbeemedia.enigma.core.player.track.BasePlayerImplementationTrack;

public class MockSubtitleTrack extends BasePlayerImplementationTrack {
    private String language;
    private final ISubtitleTrack subtitleTrack = new ISubtitleTrack() {
        @Override
        public String getLanguageCode() {
            return language;
        }
    };

    public MockSubtitleTrack(String language) {
        this.language = language;
    }

    @Override
    public ISubtitleTrack asSubtitleTrack() {
        return subtitleTrack;
    }
}
