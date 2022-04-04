package com.redbeemedia.enigma.core.audio;

import com.redbeemedia.enigma.core.player.track.BasePlayerImplementationTrack;

public class MockAudioTrack extends BasePlayerImplementationTrack {
    private String language;
    private final IAudioTrack audioTrack = new IAudioTrack() {
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
    };

    public MockAudioTrack(String language) {
        this.language = language;
    }

    @Override
    public IAudioTrack asAudioTrack() {
        return audioTrack;
    }
}
