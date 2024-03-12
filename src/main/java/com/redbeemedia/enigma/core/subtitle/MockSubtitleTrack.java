package com.redbeemedia.enigma.core.subtitle;

import com.redbeemedia.enigma.core.player.track.BasePlayerImplementationTrack;

public class MockSubtitleTrack extends BasePlayerImplementationTrack {
    private String language;
    private final ISubtitleTrack subtitleTrack = new ISubtitleTrack() {
        @Override
        public String getTrackId() {
            return null;
        }

        @Override
        public String getLabel() {
            return language;
        }

        @Override
        public String getCode() {
            return language;
        }

        @Override
        public boolean isForcedSubtitle() {
            return false;
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
