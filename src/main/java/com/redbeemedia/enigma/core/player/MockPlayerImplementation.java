package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.audio.IAudioTrack;
import com.redbeemedia.enigma.core.player.timeline.ITimelinePosition;
import com.redbeemedia.enigma.core.subtitle.ISubtitleTrack;

public class MockPlayerImplementation implements IPlayerImplementation, IPlayerImplementationControls, IPlayerImplementationInternals {
    private IPlayerImplementationListener playerImplementationListener;
    protected ITimelinePositionFactory timelinePositionFactory;

    public Boolean isLiveStream = false;
    public long currentPosition = 1234;
    public long livePosition = 9000;
    public long duration = 10000;

    @Override
    public void install(IEnigmaPlayerEnvironment environment) {
        environment.setControls(this);
        environment.setInternals(this);
        this.playerImplementationListener = environment.getPlayerImplementationListener();
        this.timelinePositionFactory = environment.getTimelinePositionFactory();
    }

    @Override
    public void load(ILoadRequest loadRequest, IPlayerImplementationControlResultHandler resultHandler) {
        resultHandler.onDone();
        if(playerImplementationListener != null) {
            playerImplementationListener.onLoadCompleted();
        }
    }

    @Override
    public void start(IPlayerImplementationControlResultHandler resultHandler) {
        resultHandler.onDone();
        if(playerImplementationListener != null) {
            playerImplementationListener.onPlaybackStarted();
        }
    }

    @Override
    public void pause(IPlayerImplementationControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void stop(IPlayerImplementationControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void seekTo(ISeekPosition seekPosition, IPlayerImplementationControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void setVolume(float volume, IPlayerImplementationControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void setSubtitleTrack(ISubtitleTrack track, IPlayerImplementationControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void setAudioTrack(IAudioTrack track, IPlayerImplementationControlResultHandler resultHandler) {
        resultHandler.onDone();
    }

    @Override
    public void release() {
    }

    @Override
    public ITimelinePosition getCurrentPosition() {
        return timelinePositionFactory.newPosition(currentPosition);
    }

    @Override
    public ITimelinePosition getCurrentStartBound() {
        return timelinePositionFactory.newPosition(0L);
    }

    @Override
    public ITimelinePosition getCurrentEndBound() {
        return timelinePositionFactory.newPosition(duration);
    }

    @Override
    public ITimelinePosition getLivePosition() {
        return isLiveStream ? timelinePositionFactory.newPosition(livePosition) : null;
    }

    @Override
    public IPlaybackTechnologyIdentifier getTechnologyIdentifier() {
        return new MockPlaybackTechnologyIdentifier();
    }

    public IPlayerImplementationListener getPlayerImplementationListener() {
        return playerImplementationListener;
    }

    public ITimelinePositionFactory getTimelinePositionFactory() {
        return timelinePositionFactory;
    }

    @Override
    public void setMaxVideoTrackDimensions(int width, int height, IPlayerImplementationControlResultHandler controlResultHandler) {
    }
}
