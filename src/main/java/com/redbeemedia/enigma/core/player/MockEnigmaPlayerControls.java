package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.audio.IAudioTrack;
import com.redbeemedia.enigma.core.player.controls.AbstractEnigmaPlayerControls;
import com.redbeemedia.enigma.core.player.controls.IControlResultHandler;
import com.redbeemedia.enigma.core.subtitle.ISubtitleTrack;
import com.redbeemedia.enigma.core.video.IVideoTrack;

public class MockEnigmaPlayerControls extends AbstractEnigmaPlayerControls {
    private EnigmaPlayerState state = EnigmaPlayerState.IDLE;

    @Override
    protected IControlResultHandler getDefaultResultHandler() {
        return new DefaultControlResultHandler("UNIT_TEST");
    }

    @Override
    public void start(IControlResultHandler resultHandler) {
        resultHandler.onDone();
        state = EnigmaPlayerState.PLAYING;
    }

    @Override
    public void pause(IControlResultHandler resultHandler) {
        resultHandler.onDone();
        state = EnigmaPlayerState.PAUSED;
    }

    @Override
    public void stop(IControlResultHandler resultHandler) {
        resultHandler.onDone();
        state = EnigmaPlayerState.IDLE;
    }

    @Override
    public void setVolume(float volume, IControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void setSubtitleTrack(ISubtitleTrack track, IControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void setSubtitleTrackById(String trackId, IControlResultHandler resultHandler) {

    }

    @Override
    public void setAudioTrack(IAudioTrack track, IControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void setAudioTrackById(String trackId, IControlResultHandler resultHandler) {

    }

    @Override
    public void setVideoTrack(IVideoTrack track, IControlResultHandler resultHandler) {

    }

    @Override
    public void seekTo(long millis, IControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void seekTo(StreamPosition streamPosition, IControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void nextProgram(IControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void previousProgram(IControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void setMaxVideoTrackDimensions(int width, int height, IControlResultHandler resultHandler) {
        resultHandler.onDone();
    }
}
