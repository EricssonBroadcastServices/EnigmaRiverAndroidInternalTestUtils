package com.redbeemedia.enigma.core.player.track;

import com.redbeemedia.enigma.core.audio.IAudioTrack;
import com.redbeemedia.enigma.core.subtitle.ISubtitleTrack;

public class MockPlayerImplementationTrack implements IPlayerImplementationTrack {
    @Override
    public ISubtitleTrack asSubtitleTrack() {
        return null;
    }

    @Override
    public IAudioTrack asAudioTrack() {
        return null;
    }
}
