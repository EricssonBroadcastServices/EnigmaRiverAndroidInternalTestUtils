package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.audio.IAudioTrack;
import com.redbeemedia.enigma.core.subtitle.ISubtitleTrack;
import com.redbeemedia.enigma.core.video.IVideoTrack;

import java.util.HashMap;
import java.util.Map;

public class MockIPlayerImplementationControls implements IPlayerImplementationControls {
    @Override
    public void load(ILoadRequest loadRequest, IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void start(IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void pause(IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void stop(IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void seekTo(ISeekPosition seekPosition, IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void setVolume(float volume, IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void setSubtitleTrack(ISubtitleTrack track, IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void setAudioTrack(IAudioTrack track, IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void setVideoTrack(IVideoTrack track, IPlayerImplementationControlResultHandler resultHandler) {

    }

    @Override
    public void setMaxVideoTrackDimensions(int width, int height, IPlayerImplementationControlResultHandler controlResultHandler) {

    }

    @Override
    public Map<String, String> getDrmKeyStatusMap() {
        return new HashMap<>();
    }
}
