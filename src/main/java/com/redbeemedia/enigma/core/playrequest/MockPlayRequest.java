package com.redbeemedia.enigma.core.playrequest;

import com.redbeemedia.enigma.core.playable.IPlayable;
import com.redbeemedia.enigma.core.playable.MockPlayable;
import com.redbeemedia.enigma.core.session.ISession;

public class MockPlayRequest extends BasePlayRequest {
    private IPlayable playable;
    private IPlaybackProperties playbackProperties;
    private IPlayResultHandler resultHandler;
    private ISession session = null;

    public MockPlayRequest() {
        this("mockAssetID");
    }

    public MockPlayRequest(String mockAssetId) {
        this.playable = new MockPlayable(mockAssetId);
        this.playbackProperties = new MockPlaybackProperties();
        this.resultHandler = new MockPlayResultHandler();
    }

    @Override
    public IPlayable getPlayable() {
        return playable;
    }

    @Override
    public IPlaybackProperties getPlaybackProperties() {
        return playbackProperties;
    }

    @Override
    public IPlayResultHandler getResultHandler() {
        return resultHandler;
    }

    public MockPlayRequest setPlayable(IPlayable playable) {
        this.playable = playable;
        return this;
    }

    public MockPlayRequest setPlaybackProperties(IPlaybackProperties playbackProperties) {
        this.playbackProperties = playbackProperties;
        return this;
    }

    public MockPlayRequest setResultHandler(IPlayResultHandler resultHandler) {
        this.resultHandler = resultHandler;
        return this;
    }

    public MockPlayRequest setSession(ISession session) {
        this.session = session;
        return this;
    }

    @Override
    public ISession getSession() {
        return session;
    }
}
