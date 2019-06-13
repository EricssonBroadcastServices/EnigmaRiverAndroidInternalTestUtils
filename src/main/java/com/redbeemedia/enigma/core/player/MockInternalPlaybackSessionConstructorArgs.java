package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.session.ISession;
import com.redbeemedia.enigma.core.session.MockSession;
import com.redbeemedia.enigma.core.time.ITimeProvider;
import com.redbeemedia.enigma.core.time.MockTimeProvider;

public class MockInternalPlaybackSessionConstructorArgs {
    private ISession session = new MockSession();
    private String id = "mockPBS";
    private ITimeProvider timeProvider = new MockTimeProvider();
    private StreamInfo streamInfo = StreamInfo.createForNull();
    private IPlaybackSessionInfo playbackSessionInfo = new MockPlaybackSessionInfo();

    public InternalPlaybackSession.ConstructorArgs create() {
        return new InternalPlaybackSession.ConstructorArgs(session, id, timeProvider, streamInfo, playbackSessionInfo);
    }

    public ISession getSession() {
        return session;
    }

    public MockInternalPlaybackSessionConstructorArgs setSession(ISession session) {
        this.session = session;
        return this;
    }

    public String getId() {
        return id;
    }

    public MockInternalPlaybackSessionConstructorArgs setId(String id) {
        this.id = id;
        return this;
    }

    public ITimeProvider getTimeProvider() {
        return timeProvider;
    }

    public MockInternalPlaybackSessionConstructorArgs setTimeProvider(ITimeProvider timeProvider) {
        this.timeProvider = timeProvider;
        return this;
    }

    public StreamInfo getStreamInfo() {
        return streamInfo;
    }

    public MockInternalPlaybackSessionConstructorArgs setStreamInfo(StreamInfo streamInfo) {
        this.streamInfo = streamInfo;
        return this;
    }

    public IPlaybackSessionInfo getPlaybackSessionInfo() {
        return playbackSessionInfo;
    }

    public MockInternalPlaybackSessionConstructorArgs setPlaybackSessionInfo(IPlaybackSessionInfo playbackSessionInfo) {
        this.playbackSessionInfo = playbackSessionInfo;
        return this;
    }
}
